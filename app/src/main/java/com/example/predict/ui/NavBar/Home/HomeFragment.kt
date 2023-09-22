package com.example.predict.ui.NavBar.Home


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.R
import com.example.predict.data.MatchProvider
import com.example.predict.databinding.FragmentHomeBinding


class HomeFragment : androidx.fragment.app.Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {




        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclingViewLiveMatch()
        initRecyclingViewLastMatch()

        val intent = Intent(context,HomeFragment::class.java)
       val bundle = intent.extras
        val email = bundle?.getString("email")
        setup(email?:"")


        //Guardar datos
        val prefs = activity?.getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)?.edit()
        prefs?.putString("email",email)
        prefs?.apply()
    }
    private fun setup(email:String){

    }

    private fun initRecyclingViewLiveMatch() {
        val manager =  LinearLayoutManager(context)

        //val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvMatchLive

        recyclerView.layoutManager = manager
        recyclerView.adapter = MatchLiveAdapter(MatchProvider.MatchList)
        // recyclerView.addItemDecoration(decoration)
    }
    private fun initRecyclingViewLastMatch() {
        val manager =  LinearLayoutManager(context)

        //val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvLastMatch

        recyclerView.layoutManager = manager
        recyclerView.adapter = MatchLastAdapter(MatchProvider.MatchList)
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

