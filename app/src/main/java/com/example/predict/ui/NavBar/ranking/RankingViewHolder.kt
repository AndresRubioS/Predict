package com.example.predict.ui.NavBar.ranking

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.data.model.User
import com.example.predict.databinding.ItemRankingBinding

class RankingViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemRankingBinding.bind(view)

    fun render(RankingModel: User){

            binding.tvNameUser.text = RankingModel.nombrE_USUARIO ?: "Nombre de usuario no disponible"
            binding.tvRacha.text = RankingModel.posicioN_ANNO?.toString() ?: "Racha no disponible"
            binding.tvTotal.text = RankingModel.posicioN_MES?.toString() ?: "Total no disponible"
            binding.tvPremio.text = RankingModel.puntuacioN_ANNIO?.toString() ?: "0" // Convierte el valor numérico a texto directamente


        // Glide.with(binding.ivUserImage.context)
         //   .load(RankingModel.FotoUsuario)
           // .into(binding.ivUserImage)


        //posicion
        //racha/puntos puntuacion


        // PANTALLA PERFIL
        //1- MANUAL
        //2-CONFIGURACION EDIITAR PERFIL
        //3 TERMINOS Y CONDICIONES
        //4 CERRAR SESION

        //bote del mes









    }
}