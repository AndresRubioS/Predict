package com.example.predict.ui.NavBar.predict

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.data.MatchProvider
import com.example.predict.data.PredictProvider
import com.example.predict.databinding.FragmentPredictBinding
import com.example.predict.ui.NavBar.Home.MatchLastAdapter

class PredictFragment : Fragment() {
    private var _binding: FragmentPredictBinding? = null
    private val binding get() = _binding!!


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
        initRecyclingViewPredict()
    }

    private fun initRecyclingViewPredict() {
        val manager =  LinearLayoutManager(context)

        val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvPredict

        recyclerView.layoutManager = manager
        recyclerView.adapter = PredictAdapter(PredictProvider.PredictList)
        recyclerView.addItemDecoration(decoration)
        Log.d("prueba",PredictProvider.PredictList.toString())

    }
}