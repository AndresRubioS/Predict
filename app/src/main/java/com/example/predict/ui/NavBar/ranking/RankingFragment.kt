package com.example.predict.ui.NavBar.ranking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.databinding.FragmentRankingBinding
import com.example.predict.ui.NavBar.Home.RankingAdapter
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope
import com.example.predict.data.model.User


/**
 * A simple [Fragment] subclass.
 * Use the [RankingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RankingFragment : Fragment() {
    private var _binding: FragmentRankingBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RankingViewModel





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRankingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RankingViewModel::class.java)
        lifecycleScope.launch {
            try {
                val response = viewModel.executeGetRequestList()
                initRecyclingView(response)
                Log.d("response", "solicitud: ${response}")
            } catch (e: Exception) {
                // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
                Log.e("Error", "Error en la solicitud: ${e.message}")
            }
        }

    }

    private fun initRecyclingView(response :List<User>) {

        val sortedResponse = response.sortedByDescending {
            it.puntuacioN_ANNIO?.toString()?.toIntOrNull() ?: 0
        }
        val manager = LinearLayoutManager(context)

        val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvRanking

        recyclerView.layoutManager = manager
        recyclerView.adapter = RankingAdapter(sortedResponse)
         recyclerView.addItemDecoration(decoration)
    }


}