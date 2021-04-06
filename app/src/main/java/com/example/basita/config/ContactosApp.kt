package com.example.basita.config

import android.app.Application
import androidx.room.Room


class ContactosApp :Application(){
    companion object{
     lateinit var  db:ContactoDB
    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            this,
            ContactoDB::class.java,
            "contactos_database"
        ).build()
    }
}