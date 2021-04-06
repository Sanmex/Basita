package com.example.basita.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactoE(
    @PrimaryKey(autoGenerate=true)
    val idCon: Int,
    val nombre:String,
    val tel:String
        )