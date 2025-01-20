package com.alexramos.examen_alex_ramos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MobleDAO {

    //Consultes

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun afegirMoble(moble: Moble)


    //select all
    @Query("SELECT * FROM Furniture ORDER BY name DESC")
    fun obtenirMoble(): LiveData<List<Moble>>

}