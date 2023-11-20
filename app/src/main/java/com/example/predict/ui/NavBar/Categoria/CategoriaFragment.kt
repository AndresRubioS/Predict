package com.example.predict.ui.NavBar.Categoria

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.predict.R
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.data.Categoria
import com.example.predict.databinding.FragmentCategoriaBinding
import com.example.predict.databinding.FragmentPredictBinding
import kotlinx.coroutines.launch

class CategoriaFragment : Fragment() {
    private var _binding: FragmentCategoriaBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CategoriaViewModel



    companion object {
        fun newInstance() = CategoriaFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
        lifecycleScope.launch {
            try {
                Log.d("onActivityCreated", "onActivityCreated called")
                val response = viewModel.executeGetRequestCategoriaList()
                Log.d("responseerror", response.toString())
                initRecyclingView(response)
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
                Log.e("Error", "Error en la solicitud: ${e.message}")
            }
        }

        // TODO: Use the ViewModel
    }
    private fun initRecyclingView(response: List<Categoria>) {
        val manager = LinearLayoutManager(context)
        val decoration = DividerItemDecoration(context, manager.orientation)
        val recyclerView = binding.rvCategoria
        recyclerView.layoutManager = manager
        recyclerView.adapter = CategoriaAdapter(response)
        recyclerView.addItemDecoration(decoration)
    }


}