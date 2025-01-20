package com.alexramos.examen_alex_ramos

import android.content.Context
import androidx.lifecycle.LiveData
import com.alexramos.examen_alex_ramos.data.Moble
//import com.alexramos.examen_alex_ramos.data.Moble
import com.alexramos.examen_alex_ramos.data.dataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repositori {
    companion object {
        var repositori_database: dataBase? = null

        var mobles: LiveData<List<Moble>>? = null

        //funció per a inicialitzar la BD

        fun initializeDB(context: Context): dataBase {
            return dataBase.getDatabase(context)
        }


        fun inserirMoble(context: Context, moble: Moble) {

            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                repositori_database!!.MobleDao().afegirMoble(moble)
            }
        }


        fun obtenirMobles(context: Context): LiveData<List<Moble>>? {
            //Connectar la BD
            repositori_database = initializeDB(context)

            CoroutineScope(IO).launch {
                mobles = repositori_database!!.MobleDao().obtenirMoble()
            }

            return mobles

        }

    }
}