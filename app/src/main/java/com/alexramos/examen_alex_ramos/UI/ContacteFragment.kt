package com.alexramos.examen_alex_ramos.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexramos.examen_alex_ramos.databinding.FragmentContacteBinding

class ContacteFragment : Fragment() {
    private lateinit var binding: FragmentContacteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContacteBinding.inflate(inflater, container, false)



        return binding.root
    }
}