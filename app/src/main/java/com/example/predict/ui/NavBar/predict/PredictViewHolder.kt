package com.example.predict.ui.NavBar.predict

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.predict.data.Predict
import com.example.predict.databinding.ItemPredictBinding

class PredictViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemPredictBinding.bind(view)

    fun render(MatchModel: Predict){
        binding.tvNameHomeTeam.text = MatchModel.equipO_LOCAL_ID
        binding.tvNameVisitTeam.text = MatchModel.equipO_VISITANTE_ID
        binding.tvScoreHome.text = MatchModel.goleS_EQUIPO_LOCAL.toString()
        binding.tvScoreVisit.text = MatchModel.goleS_EQUIPO_VISITANTE.toString()

        binding.btScoreHomeUp.setOnClickListener {
          val fin = (binding.tvScoreHome.text as String).toInt()
            val numero = fin + 1
            binding.tvScoreHome.setText(numero.toString())
        }
        binding.btScoreHomeDown.setOnClickListener {
            var fin = (binding.tvScoreHome.text as String).toInt() -1
            var cero = 0
            binding.tvScoreHome.setText(fin.toString())
            if (fin<=0){
                binding.tvScoreHome.setText(cero.toString())
            }
        }
        binding.btScoreVisitUp.setOnClickListener {
            val fin = (binding.tvScoreVisit.text as String).toInt()
            val numero = fin + 1
            binding.tvScoreVisit.setText(numero.toString())
        }

        binding.btScoreVisitDown.setOnClickListener {
            var fin = (binding.tvScoreVisit.text as String).toInt() -1
            var cero = 0
            binding.tvScoreVisit.setText(fin.toString())
            if (fin<=0){
                binding.tvScoreVisit.setText(cero.toString())
            }
        }
        //Glide.with(binding.ivHomeTeam.context)
          //  .load(MatchModel.ImageHome)
           // .into(binding.ivHomeTeam)
        //Glide.with(binding.ivVisitTeam.context)
            //.load(MatchModel.ImageVisit)
          //  .into(binding.ivVisitTeam)







    }
}