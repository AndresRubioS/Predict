package com.example.predict.ui.NavBar.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.R
import com.example.predict.data.MatchProvider
import com.example.predict.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {




        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclingView()
    }

    private fun initRecyclingView() {
        val manager =  LinearLayoutManager(context)

        //val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvMatchLive

        recyclerView.layoutManager = manager
        recyclerView.adapter = HomeAdapter(MatchProvider.MatchList)
        // recyclerView.addItemDecoration(decoration)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
    }



    companion object {

        fun newInstance() = HomeFragment()

            }

    }

