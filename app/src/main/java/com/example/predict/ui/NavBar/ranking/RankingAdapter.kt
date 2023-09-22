package com.example.predict.ui.NavBar.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.R
import com.example.predict.ui.NavBar.ranking.RankingViewHolder

class RankingAdapter(private val rankingList: List<com.example.predict.data.model.User>): RecyclerView.Adapter<RankingViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RankingViewHolder(layoutInflater.inflate(R.layout.item_ranking, parent, false))
    }

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        val item = rankingList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int = rankingList.size

}