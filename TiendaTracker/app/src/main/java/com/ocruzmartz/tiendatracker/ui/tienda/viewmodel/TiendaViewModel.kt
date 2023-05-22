package com.ocruzmartz.tiendatracker.ui.tienda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ocruzmartz.tiendatracker.TiendaReviewerApplication
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.data.tienda
import com.ocruzmartz.tiendatracker.repositories.TiendaRepository

class TiendaViewModel(private val repository: TiendaRepository) : ViewModel() {
    var name = MutableLiveData("")
    var address = MutableLiveData("")
    var status = MutableLiveData("")

    fun getTienda() = repository.getTienda()
    fun addTiendas(tienda: TiendaModel) = repository.addTiendas(tienda)

    fun createTienda() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val tienda = TiendaModel(
            name.value!!,
            address.value!!,
        )

        addTiendas(tienda)
        clearData()

        status.value = TIENDA_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrBlank() -> return false
            address.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun clearData() {
        name.value = ""
        address.value = ""
    }

    fun setSelectedTienda(movie: TiendaModel){
        name.value = movie.name
        address.value = movie.address
    }


    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as TiendaReviewerApplication
                TiendaViewModel(app.tiendaRepository)
            }
        }

        const val TIENDA_CREATED = "Tienda created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}