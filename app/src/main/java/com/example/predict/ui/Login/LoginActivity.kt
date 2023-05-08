package com.example.predict.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.predict.databinding.ActivityMainBinding
import com.example.predict.ui.register_activity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        pantallaRegistro()

    }

    private fun pantallaRegistro() {
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, register_activity::class.java)
            startActivity(intent)
        }
    }

}