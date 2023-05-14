package com.example.predict.ui.NavBar.predict

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.predict.R
import com.example.predict.data.Predict

class PredictAdapter(private val predictList:List<Predict>): RecyclerView.Adapter<PredictViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PredictViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PredictViewHolder(layoutInflater.inflate(R.layout.item_predict, parent, false))
    }

    override fun onBindViewHolder(holder: PredictViewHolder, position: Int) {
        val item = predictList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int = 7

}