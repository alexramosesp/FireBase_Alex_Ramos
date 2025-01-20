package com.alexramos.examen_alex_ramos.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.alexramos.examen_alex_ramos.Repositori
import com.alexramos.examen_alex_ramos.data.Moble

class afegirMobleViewModel: ViewModel() {
    //funció cridar repositori fegir cotxes
    fun nouMoble(context: Context, nom:String, preu:Int) {

        var cotxeVM=Moble(nom, preu)
        Repositori.inserirMoble(context,cotxeVM)
    }
}