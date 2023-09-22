package com.example.predict.ui.Login
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.predict.R
import com.example.predict.databinding.ActivityRegisterBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

class RegisterActivity : AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding  // Declarar la variable de enlace


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)  // Inflar la vista usando ViewBinding
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)



        binding.button.setOnClickListener {
            val username = binding.etName.text.toString()
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.etPassword.text.toString()



            viewModel.registerUser(username, email, password) { success, result ->
                if (success) {
                    // Manejar la respuesta exitosa aquí (result contiene la respuesta)
                    Log.d("SolicitudExitosa", "Solicitud exitosa. Respuesta: $result")
                } else {
                    // Manejar el error de la solicitud aquí (result contiene el mensaje de error)
                    Log.e("ErrorSolicitud", "Error en la solicitud. Mensaje de error: $result")
                }
            }
        }
    }
}
