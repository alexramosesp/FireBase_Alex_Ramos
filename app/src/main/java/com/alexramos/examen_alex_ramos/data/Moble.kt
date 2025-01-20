package com.alexramos.examen_alex_ramos.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Furniture")
data class Moble(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "price")
    var price: Int
){
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}