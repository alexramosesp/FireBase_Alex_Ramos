package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexramos.examen_alex_ramos.Adapter.HomeAdapter
import com.alexramos.examen_alex_ramos.R
import com.alexramos.examen_alex_ramos.ViewModels.homeViewModel
import com.alexramos.examen_alex_ramos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var homeViewmodel: homeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )

        homeViewmodel = ViewModelProvider(this).get(homeViewModel::class.java)
        homeViewmodel.llistar_mobles(requireContext())
        binding.recyclerViewMobles.layoutManager = LinearLayoutManager(requireContext())

        homeViewmodel.llistat_mobles?.observe(viewLifecycleOwner) { llistatMobles ->
            binding.recyclerViewMobles.adapter = HomeAdapter(llistatMobles) { item ->
                val bundle = Bundle().apply {
                    putString("selectedItem", item.name)
                    putDouble("itemPrice", item.price.toDouble())
                    item.Id?.let { putInt("itemID", it) }
                }
                view?.findNavController()
                    ?.navigate(R.id.action_homeFragment_to_llistarMobleFragment, bundle)
            }
        }

        binding.buttonToAfegir.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_afegirMobleFragment)
        }


        return binding.root

    }
}