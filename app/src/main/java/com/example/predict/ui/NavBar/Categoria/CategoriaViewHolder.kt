package com.example.predict.ui.NavBar.Categoria

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.predict.data.Categoria
import com.example.predict.databinding.ItemCategoriaBinding


class CategoriaViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemCategoriaBinding.bind(view)

    fun render(categoriaModel: Categoria){

        binding.btnCategoria.text = categoriaModel.nombre
        Log.d("categoria_imagen",categoriaModel.urI_IMAGEN)
        Glide.with(binding.imageView.context)
          .load("https://ibb.co/7tgd5Ds")
         .into(binding.imageView)

    }
}