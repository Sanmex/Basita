package com.example.basita.dao

import androidx.room.*
import com.example.basita.models.ContactoE


@Dao
interface ContactoDao {
    @Query("select*from ContactoE")
    fun getAll(): List<ContactoE>
    //editar
    @Query("select * from ContactoE where idCon=:id")
    fun getById(id:Long):ContactoE


    //inserta una o muchas personas
    @Insert
    suspend fun inserto(contactos: List<ContactoE>): List<Long>

    @Update
    suspend fun update(contacto: ContactoE): Int //cuantas filas fueron actualizadas
    //devuelve entero de cuantas filas fueron actualizadas

    @Delete
    suspend fun delete(contacto: ContactoE): Int//si fue borrado
    //devuelve numero de registros que ahan sido botrados
}