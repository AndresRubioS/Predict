package com.example.predict.ui.NavBar.predict

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.data.Predict
import com.example.predict.data.PredictProvider
import com.example.predict.databinding.FragmentPredictBinding
import com.example.predict.ui.NavBar.ranking.RankingViewModel
import kotlinx.coroutines.launch

class PredictFragment : Fragment() {
    private var _binding: FragmentPredictBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PredictViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPredictBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = PredictFragment()


    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PredictViewModel::class.java)
        lifecycleScope.launch {
            try {
                val response = viewModel.executeGetRequestListPredict()
                initRecyclingViewPredict(response)

                Log.d("response", "solicitud: ${response}")
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
                Log.e("Error", "Error en la solicitud: ${e.message}")
            }
        }
    }

    private fun initRecyclingViewPredict(response: List<Predict>) {
        val manager =  LinearLayoutManager(context)

        val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvPredict

        recyclerView.layoutManager = manager
        recyclerView.adapter = PredictAdapter(response)
        recyclerView.addItemDecoration(decoration)
        Log.d("prueba",PredictProvider.PredictList.toString())

    }
}