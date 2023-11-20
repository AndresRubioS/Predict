package com.example.predict.ui.NavBar.promos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.R
import com.example.predict.data.Categoria
import com.example.predict.data.model.Promos
import com.example.predict.ui.NavBar.Categoria.CategoriaViewHolder


class PromosAdapter(private val predictList:List<Promos>): RecyclerView.Adapter<PromosViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PromosViewHolder(layoutInflater.inflate(R.layout.item_promos, parent, false))
    }

    override fun onBindViewHolder(holder: PromosViewHolder, position: Int) {
        val item = predictList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int  = predictList.size

}