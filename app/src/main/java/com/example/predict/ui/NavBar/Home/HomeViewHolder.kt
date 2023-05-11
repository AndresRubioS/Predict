package com.example.predict.ui.NavBar.Home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.data.Match
import com.example.predict.databinding.ItemPartidoBinding

class HomeViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemPartidoBinding.bind(view)

    fun render(MatchModel: Match){
        binding.tvNameHomeTeam.text = MatchModel.NameHome
        binding.tvNameVisitTeam.text = MatchModel.NameVisit
        binding.tvScoreHome.text = MatchModel.ScoreHome
        binding.tvScoreVisit.text = MatchModel.ScoreVisit








    }
}