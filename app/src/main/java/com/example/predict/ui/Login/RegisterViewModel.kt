package com.example.predict.ui.Login
import androidx.lifecycle.ViewModel
import com.example.predict.data.ApiRequestBuilder
import com.example.predict.data.model.User
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException

class RegisterViewModel : ViewModel() {
    private val okHttpClient = OkHttpClient()

    fun registerUser(
        username: String,
        email: String,
        password: String,
        onComplete: (Boolean, String?) -> Unit
    ) {
        val jsonObject = JSONObject()
        jsonObject.put("nombrE_USUARIO", username)
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val request = ApiRequestBuilder.createPostRequest("api/Usuario",jsonObject.toString())
        //User(jsonObject.getString("nombrE_USUARIO"),jsonObject.getString("nombrE_USUARIO"),jsonObject.getString("nombrE_USUARIO"))



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

