package com.example.predict.ui.NavBar.predict

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.predict.data.ApiRequestBuilder
import com.example.predict.data.Predict
import com.example.predict.data.model.User
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import java.io.IOException

class PredictViewModel : ViewModel() {

    private val client = OkHttpClient()
    private val gson = Gson()
    private var jornadaId: String? = null // Variable para almacenar el jornadA_ID

    suspend fun executeGetRequestJornada(): String {
        return withContext(Dispatchers.IO) {
            try {
                val request = ApiRequestBuilder.createGetRequest("api/jornadas/actual")

                val response = client.newCall(request).execute()
                if (!response.isSuccessful) {
                    throw IOException("Error en la solicitud. Código de error: ${response.code}")
                }

                // Obtener el JSON de la respuesta
                val jsonResponse = response.body?.string() ?: ""

                // Parsear el JSON para obtener el jornadA_ID y almacenarlo
                val jsonArray = JsonParser.parseString(jsonResponse).asJsonArray
                if (jsonArray.size() > 0) {
                    val jsonObject = jsonArray[0].asJsonObject
                    jornadaId = jsonObject.get("jornadA_ID").asString
                }

                return@withContext jsonResponse
            } catch (e: IOException) {
                throw e
            }
        }
    }

    suspend fun executeGetRequestPartidos(): String {
        // Ejecutar el primer GET para obtener el jornadA_ID
        executeGetRequestJornada()

        // Utilizar el jornadA_ID en el segundo GET
        return withContext(Dispatchers.IO) {
            try {
                val request = ApiRequestBuilder.createGetRequest("api/partidos/$jornadaId") // Utiliza el jornadA_ID aquí
                Log.d("requestPredict", request.toString())
                val response = client.newCall(request).execute()
                if (!response.isSuccessful) {
                    throw IOException("Error en la solicitud. Código de error: ${response.code}")
                }

                return@withContext response.body?.string() ?: ""
            } catch (e: IOException) {
                throw e
            }
        }
    }
    suspend fun executeGetRequestListPredict(): List<Predict> {
        val response = executeGetRequestPartidos()
        val resultList = mutableListOf<Predict>()
        try {
            val jsonArray = gson.fromJson(response, Array<Predict>::class.java)
            resultList.addAll(jsonArray)
        } catch (e: Exception) {
            throw e
        }
        return resultList
    }
}
