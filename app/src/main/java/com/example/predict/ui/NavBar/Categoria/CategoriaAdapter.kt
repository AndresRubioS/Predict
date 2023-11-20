package com.example.predict.ui.NavBar.Categoria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.R
import com.example.predict.data.Categoria


class CategoriaAdapter(private val predictList:List<Categoria>): RecyclerView.Adapter<CategoriaViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoriaViewHolder(layoutInflater.inflate(R.layout.item_categoria, parent, false))
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val item = predictList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int  = predictList.size

}