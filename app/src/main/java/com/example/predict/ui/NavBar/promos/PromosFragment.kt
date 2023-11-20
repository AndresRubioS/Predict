package com.example.predict.ui.NavBar.promos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.data.Categoria
import com.example.predict.data.model.Promos
import com.example.predict.databinding.FragmentPromosBinding
import com.example.predict.ui.NavBar.Categoria.CategoriaAdapter
import com.example.predict.ui.NavBar.Categoria.CategoriaFragment
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [PromosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PromosFragment : Fragment() {
    private var _binding: FragmentPromosBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PromosViewModel



    companion object {
        fun newInstance() = CategoriaFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPromosBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PromosViewModel::class.java)
        lifecycleScope.launch {
            try {
                Log.d("onActivityCreated", "onActivityCreated called")
                val response = viewModel.executeGetRequestPromosList()
                Log.d("responseerror", response.toString())
                initRecyclingView(response)
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
                Log.e("Error", "Error en la solicitud: ${e.message}")
            }
        }

        // TODO: Use the ViewModel
    }
    private fun initRecyclingView(response: List<Promos>) {
        val numColumns = 3 // Puedes ajustar esto según tus necesidades

        // Crea un GridLayoutManager
        val gridLayoutManager = GridLayoutManager(context, numColumns)
        val recyclerView = binding.rvPromos
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = PromosAdapter(response)
    }


}