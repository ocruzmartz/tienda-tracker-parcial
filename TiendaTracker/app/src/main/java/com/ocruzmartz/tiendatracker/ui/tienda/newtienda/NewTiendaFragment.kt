package com.ocruzmartz.tiendatracker.ui.tienda.newtienda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ocruzmartz.tiendatracker.R
import com.ocruzmartz.tiendatracker.databinding.FragmentNewTiendaBinding

class NewTiendaFragment : Fragment() {

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

}