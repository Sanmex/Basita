package com.example.basita.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basita.dao.ContactoDao
import com.example.basita.models.ContactoE

@Database(
    entities=[ContactoE::class],version=2,

)
abstract class ContactoDB: RoomDatabase() {

    abstract fun contactoDao():ContactoDao
}