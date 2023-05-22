package com.example.predict.ui.NavBar.ranking

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.predict.data.Match
import com.example.predict.data.Ranking
import com.example.predict.databinding.ItemPartidoBinding
import com.example.predict.databinding.ItemRankingBinding

class RankingViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemRankingBinding.bind(view)

    fun render(RankingModel: Ranking){
        binding.tvNameUser.text = RankingModel.NameUsuario
        binding.tvRacha.text = RankingModel.Racha
        binding.tvTotal.text = RankingModel.Total
        binding.tvPremio.text = RankingModel.Premio
        Glide.with(binding.ivUserImage.context)
            .load(RankingModel.FotoUsuario)
            .into(binding.ivUserImage)








    }
}