package com.alexramos.examen_alex_ramos.ViewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexramos.examen_alex_ramos.Repositori
import com.alexramos.examen_alex_ramos.data.Moble

class homeViewModel:ViewModel() {


    private var _llistat_mobles: LiveData<List<Moble>>? = null
    val llistat_mobles: LiveData<List<Moble>>?
        get() = _llistat_mobles


    fun llistar_mobles(context: Context) {
        _llistat_mobles = Repositori.obtenirMobles(context)
    }
}