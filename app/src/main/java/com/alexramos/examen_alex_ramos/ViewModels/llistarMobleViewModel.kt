package com.alexramos.examen_alex_ramos.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.alexramos.examen_alex_ramos.Repositori
import com.alexramos.examen_alex_ramos.data.Moble

class llistarMobleViewModel: ViewModel() {
    //funció cridar repositori fegir cotxes
    fun eliminarMoble(context: Context, nom:String, preu:Int) {

        var cotxeVM= Moble(nom, preu)
        Repositori.inserirMoble(context,cotxeVM)
    }
    fun actualitzarMoble(context: Context, nom:String, preu:Int) {

        var cotxeVM= Moble(nom, preu)
        Repositori.inserirMoble(context,cotxeVM)
    }
}