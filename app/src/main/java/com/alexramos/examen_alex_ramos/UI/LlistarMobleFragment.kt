package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alexramos.examen_alex_ramos.R
import com.alexramos.examen_alex_ramos.ViewModels.afegirMobleViewModel
import com.alexramos.examen_alex_ramos.ViewModels.llistarMobleViewModel
import com.alexramos.examen_alex_ramos.databinding.FragmentLlistarMobleBinding

class LlistarMobleFragment : Fragment() {
    private lateinit var binding: FragmentLlistarMobleBinding
    private lateinit var llistarMobleViewmodel: llistarMobleViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLlistarMobleBinding.inflate(inflater, container, false)

        val selectedItem = arguments?.getString("selectedItem")
        val itemPrice = arguments?.getDouble("itemPrice")
        val itemID = arguments?.getDouble("itemID")
        llistarMobleViewmodel = ViewModelProvider(this).get(llistarMobleViewModel::class.java)


        binding.textViewSelectedItem.text = getString(R.string.nom_variable, selectedItem)
        binding.textViewItemPrice.text = getString(R.string.preu_variable, itemPrice.toString())


        binding.buttonBackToHome.setOnClickListener {
            findNavController().navigate(R.id.action_llistarMobleFragment_to_homeFragment)
        }

        return binding.root
    }
}