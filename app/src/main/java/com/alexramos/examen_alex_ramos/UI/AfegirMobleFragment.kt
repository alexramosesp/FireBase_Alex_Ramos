package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alexramos.examen_alex_ramos.R
import com.alexramos.examen_alex_ramos.ViewModels.afegirMobleViewModel
import com.alexramos.examen_alex_ramos.databinding.FragmentAfegirMobleBinding

class AfegirMobleFragment : Fragment() {
    private lateinit var binding: FragmentAfegirMobleBinding

    private lateinit var afegirMobleViewmodel: afegirMobleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_afegir_moble, container, false
        )
        afegirMobleViewmodel = ViewModelProvider(this).get(afegirMobleViewModel::class.java)

        binding.buttonInsert.setOnClickListener{
            var nom = binding.editTextNom.text.toString()
            var preu = binding.editTextPreu.text.toString().toIntOrNull()
            if (nom != null) {
                if (preu != null) {
                    afegirMobleViewmodel.nouMoble(requireContext(),nom,preu)
                }
            }
        }
        binding.buttonGoToHome.setOnClickListener{
            findNavController().navigate(R.id.action_afegirMobleFragment_to_homeFragment)
        }
        return binding.root
    }
}