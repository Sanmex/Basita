package com.example.basita.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basita.config.ContactosApp.Companion.db
import com.example.basita.models.ContactoE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel:ViewModel() {
    val contactosList = MutableLiveData<List<ContactoE>?>()
    //val citalist=MutableLiveData<List<ContawithCita>>()

    var busqueda = MutableLiveData<String>()

    fun iniciar() {
        //probar insert y select
        //agregar observer a la lista
        viewModelScope.launch {
            contactosList.value= withContext(Dispatchers.IO) {

                db.contactoDao().getAll()
            }

        }



        }
    }




