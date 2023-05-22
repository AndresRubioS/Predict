package com.example.predict.ui.NavBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.predict.R
import com.example.predict.data.MatchProvider
import com.example.predict.data.RankingProvider
import com.example.predict.databinding.FragmentHomeBinding
import com.example.predict.databinding.FragmentRankingBinding
import com.example.predict.ui.NavBar.Home.MatchLiveAdapter
import com.example.predict.ui.NavBar.Home.RankingAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RankingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RankingFragment : Fragment() {
    private var _binding: FragmentRankingBinding? = null
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
        _binding = FragmentRankingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclingView()

    }

    private fun initRecyclingView() {
        val manager =  LinearLayoutManager(context)

        val decoration = DividerItemDecoration(context, manager.orientation)

        val recyclerView = binding.rvRanking

        recyclerView.layoutManager = manager
        recyclerView.adapter = RankingAdapter(RankingProvider.RankingList)
         recyclerView.addItemDecoration(decoration)
    }


}