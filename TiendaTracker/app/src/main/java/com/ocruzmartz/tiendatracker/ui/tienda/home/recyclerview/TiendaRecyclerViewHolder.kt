package com.ocruzmartz.tiendatracker.ui.tienda.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.databinding.CardItemBinding

class TiendaRecyclerViewHolder(private val binding: CardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tienda: TiendaModel, clickListener: (TiendaModel) -> Unit) {
        binding.idNameStore.text = tienda.name
        binding.idAddressStore.text = tienda.address

//        binding.idCardView.setOnClickListener {
//            clickListener(tienda)
//        }
    }
}