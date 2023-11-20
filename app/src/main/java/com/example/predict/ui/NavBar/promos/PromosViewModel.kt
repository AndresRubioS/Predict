package com.example.predict.ui.NavBar.promos

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.predict.data.ApiRequestBuilder
import com.example.predict.data.Categoria
import com.example.predict.data.model.Promos
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import java.io.IOException
import java.util.concurrent.TimeUnit

class PromosViewModel : ViewModel() {

    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    private val gson = Gson()

    suspend fun executeGetRequest(): String {
        return withContext(Dispatchers.IO) {
            try {
                val request = ApiRequestBuilder.createGetRequest("marcas")
                Log.d("requestPredict12", request.toString())

                val response = client.newCall(request).execute()
                val jsonResponse = response.body?.string() ?: ""
                Log.d("requestPredict13", jsonResponse)  // Registra el JSON de respuesta

                return@withContext jsonResponse

            } catch (e: IOException) {
                Log.e("CategoriaViewModel", "Error en la solicitud: ${e.message}")  // Registra errores
                throw e
            }
        }
    }

    suspend fun executeGetRequestPromosList(): List<Promos> {
        val response = executeGetRequest()
        Log.d("CategoriaViewModel", response) // Registra el JSON de respuesta
        val resultList = mutableListOf<Promos>()
        try {
            val jsonArray = gson.fromJson(response, Array<Promos>::class.java)
            resultList.addAll(jsonArray)
        } catch (e: Exception) {
            Log.e("CategoriaViewModel", "Error al analizar los datos: ${e.message}")  // Registra errores
            throw e
        }
        Log.d("CategoriaViewModel", resultList.toString()) // Registra la lista de categorías
        return resultList
    }
}
