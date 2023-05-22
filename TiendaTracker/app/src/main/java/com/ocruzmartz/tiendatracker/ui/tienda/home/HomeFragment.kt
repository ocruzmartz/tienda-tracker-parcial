package com.ocruzmartz.tiendatracker.ui.tienda.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ocruzmartz.tiendatracker.R
import com.ocruzmartz.tiendatracker.data.model.TiendaModel
import com.ocruzmartz.tiendatracker.databinding.FragmentHomeBinding
import com.ocruzmartz.tiendatracker.ui.tienda.home.recyclerview.TiendaRecyclerViewAdapter
import com.ocruzmartz.tiendatracker.ui.tienda.viewmodel.TiendaViewModel


class HomeFragment : Fragment() {
    private val tiendaViewModel: TiendaViewModel by activityViewModels {
        TiendaViewModel.Factory
    }

    private lateinit var adapter: TiendaRecyclerViewAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.addTienda.setOnClickListener {
            tiendaViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newTiendaFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = TiendaRecyclerViewAdapter { selectedTienda ->
            showSelectedItem(selectedTienda)
        }

        binding.recyclerView.adapter = adapter
        displayTienda()
    }

    private fun showSelectedItem(tienda: TiendaModel) {
        tiendaViewModel.setSelectedTienda(tienda)
        findNavController().navigate(R.id.action_homeFragment_to_newTiendaFragment)
    }

    private fun displayTienda() {
        adapter.setData(tiendaViewModel.getTienda())
        adapter.notifyDataSetChanged()
    }
}