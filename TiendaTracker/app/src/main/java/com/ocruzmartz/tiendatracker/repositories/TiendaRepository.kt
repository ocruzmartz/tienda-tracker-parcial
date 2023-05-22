package com.ocruzmartz.tiendatracker.repositories

import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.data.tienda

class TiendaRepository {
    fun getTienda() = tienda
    fun addTiendas(car: TiendaModel) = tienda.add(car)
}