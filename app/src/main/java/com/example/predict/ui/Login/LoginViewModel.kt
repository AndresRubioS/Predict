package com.example.predict.ui.Login

import androidx.lifecycle.ViewModel
import com.example.predict.data.ApiRequestBuilder
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException

class LoginViewModel : ViewModel() {
    private val okHttpClient = OkHttpClient()

    fun loginUser(
        username: String,
        password: String,
        onComplete: (Boolean, String?) -> Unit
    ) {
        val jsonObject = JSONObject()
        jsonObject.put("username", username)
        jsonObject.put("password", password)

        val request = ApiRequestBuilder.createPostRequest("api/Login",jsonObject.toString())





        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                onComplete(false, e.message)
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    val responseBody = response.body?.string()
                    onComplete(true, responseBody)
                } else {
                    onComplete(false, "Error en la solicitud. Código de error: ${response.code}")
                }
            }
        })
    }
}