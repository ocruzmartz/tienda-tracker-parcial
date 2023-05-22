package com.ocruzmartz.tiendatracker.repositories

import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.data.tienda

class TiendaRepository(private val tiendas: MutableList<TiendaModel>) {
    fun getTienda() = tiendas
    fun addTiendas(tienda: TiendaModel) = tiendas.add(tienda)
}