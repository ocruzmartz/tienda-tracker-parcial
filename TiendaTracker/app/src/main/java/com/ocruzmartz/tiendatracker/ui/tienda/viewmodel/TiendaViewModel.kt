package com.ocruzmartz.tiendatracker.ui.tienda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ocruzmartz.tiendatracker.TiendaReviewerApplication
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.repositories.TiendaRepository

class TiendaViewModel(private val repository: TiendaRepository) : ViewModel() {
    var name = MutableLiveData("")
    var address = MutableLiveData("")

    fun getTienda() = repository.getTienda()
    fun addTiendas(tienda: TiendaModel) = repository.addTiendas(tienda)

    companion object{
        val factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TiendaReviewerApplication
                TiendaViewModel(app.tiendaRepository)
            }
        }
    }
}