package com.example.predict.ui.Login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.predict.R
import com.example.predict.databinding.ActivityMainBinding
import com.example.predict.ui.NavBar.BottomNavigationActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = FirebaseAuth.getInstance()
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        request()

        pantallaRegistro()


    }
    fun request(){

        binding.button.setOnClickListener {
            val username = binding.etName.text.toString()

            val password = binding.etPassword.text.toString()



            viewModel.loginUser(username,password) { success, result ->
                if (success) {
                    // Manejar la respuesta exitosa aquí (result contiene la respuesta)
                    Log.d("SolicitudExitosa", "Solicitud exitosa. Respuesta: $result")
                    login()
                } else {
                    // Manejar el error de la solicitud aquí (result contiene el mensaje de error)
                    Log.e("ErrorSolicitud", "Error en la solicitud. Mensaje de error: $result")
                    login()
                }
            }
        }
    }






    private fun login() {

            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)

    }

    private fun pantallaRegistro() {
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


}