package com.ocruzmartz.tiendatracker

import android.app.Application
import com.ocruzmartz.tiendatracker.data.tienda
import com.ocruzmartz.tiendatracker.repositories.TiendaRepository

class TiendaReviewerApplication : Application(){
    val tiendaRepository: TiendaRepository by lazy{
        TiendaRepository(tienda)
    }
}