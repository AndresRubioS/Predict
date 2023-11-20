package com.example.predict.ui.NavBar.promos

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.predict.data.Categoria
import com.example.predict.data.model.Promos
import com.example.predict.databinding.ItemCategoriaBinding
import com.example.predict.databinding.ItemPromosBinding


class PromosViewHolder(view: View):  RecyclerView.ViewHolder(view) {
    val binding = ItemPromosBinding.bind(view)

    fun render(categoriaModel: Promos){


        Glide.with(binding.imageView3)
            .load("https://i.ibb.co/ZzHpPrq/la-manga-club-deportes-jpg.webp")
            .into(binding.imageView3)

    }
}