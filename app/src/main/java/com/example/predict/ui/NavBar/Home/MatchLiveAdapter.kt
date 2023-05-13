package com.example.predict.ui.NavBar.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.R
import com.example.predict.data.Match

class MatchLiveAdapter(private val matchList:List<Match>): RecyclerView.Adapter<HomeViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(layoutInflater.inflate(R.layout.item_partido, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = matchList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int = 1

}