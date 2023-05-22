package com.ocruzmartz.tiendatracker.ui.tienda.newtienda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ocruzmartz.tiendatracker.R
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.databinding.FragmentNewTiendaBinding
import com.ocruzmartz.tiendatracker.ui.tienda.viewmodel.TiendaViewModel

class NewTiendaFragment : Fragment() {

    private val viewModel: TiendaViewModel by activityViewModels {
        TiendaViewModel.Factory
    }


    private lateinit var binding: FragmentNewTiendaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_tienda, container, false)
        binding = FragmentNewTiendaBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(TiendaViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }

                status.equals(TiendaViewModel.TIENDA_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getTienda().toString())
                    viewModel.clearData()

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}