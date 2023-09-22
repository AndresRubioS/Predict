package com.example.predict.ui.NavBar.ranking

import androidx.lifecycle.ViewModel
import com.example.predict.data.ApiRequestBuilder
import com.example.predict.data.model.User
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

class RankingViewModel : ViewModel() {

    private val client = OkHttpClient()
    private val gson = Gson()

    suspend fun executeGetRequest(): String {
        return withContext(Dispatchers.IO) {
            try {
                val request = ApiRequestBuilder.createGetRequest("api/Usuario/All")

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

    suspend fun executeGetRequestList(): List<User> {
        val response = executeGetRequest()
        val resultList = mutableListOf<User>()
        try {
            val jsonArray = gson.fromJson(response, Array<User>::class.java)
            resultList.addAll(jsonArray)
        } catch (e: Exception) {
            throw e
        }
        return resultList
    }


}