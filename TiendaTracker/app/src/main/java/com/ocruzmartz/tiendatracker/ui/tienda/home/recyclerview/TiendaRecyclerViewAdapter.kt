package com.ocruzmartz.tiendatracker.ui.tienda.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.databinding.CardItemBinding

class TiendaRecyclerViewAdapter(private val clickListener: (TiendaModel) -> Unit) :
    RecyclerView.Adapter<TiendaRecyclerViewHolder>() {
    private val tiendas = ArrayList<TiendaModel>()

    fun setData(tiendasList: List<TiendaModel>) {
        tiendas.clear()
        tiendas.addAll(tiendasList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaRecyclerViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TiendaRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tiendas.size
    }

    override fun onBindViewHolder(holder: TiendaRecyclerViewHolder, position: Int) {
        val tienda = tiendas[position]
        holder.bind(tienda, clickListener)
    }
}