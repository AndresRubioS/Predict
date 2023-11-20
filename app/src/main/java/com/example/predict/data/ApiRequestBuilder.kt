package com.example.predict.data


import android.util.Log
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull


object ApiRequestBuilder {
    val baseUrl = "https://apphunters-001-site1.atempurl.com/api/"

    fun createPostRequest(endpoint: String, jsonBody: String): Request {


        val url = baseUrl + endpoint
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val requestBody = RequestBody.create(mediaType, jsonBody)
        return Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
    }
    fun createGetRequest(endpoint: String): Request {
        val url = baseUrl + endpoint
        Log.d("url", url)
        return Request.Builder()
            .url(url)
            .build()

    }
}

