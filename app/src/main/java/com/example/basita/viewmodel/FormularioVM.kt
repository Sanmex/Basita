package com.example.basita.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basita.config.Constantes
import com.example.basita.config.ContactosApp.Companion.db
import com.example.basita.models.ContactoE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FormularioVM:ViewModel() {
    //son variables no valores
    var id = MutableLiveData<Long>()
    var nombre = MutableLiveData<String>()
    var telefono = MutableLiveData<String>()
    var operacion = Constantes.OPERACION_INSERTAR
    var operacionexit = MutableLiveData<Boolean>()
    //init {
        //para dar valores predeterminados aneteros
    //}
    fun guardarContact(){
        //hay que quitar los signos de admiracion una vez que se hayan validado los datos y se asegure que no traera nulos
        var mContactos=ContactoE(0,nombre.value!!,telefono.value!!)
        when(operacion){
            Constantes.OPERACION_INSERTAR ->{
               viewModelScope.launch {
                   val result= withContext(Dispatchers.IO){
                       db.contactoDao().inserto(
                           arrayListOf(mContactos)
                       )
                   }
                   //esta variable necesita observer
                   operacionexit.value=result.isNotEmpty()
               }

            }
            Constantes.OPERACION_EDITAR ->{

            }
        }

    }

    fun cargarDatos() {
        viewModelScope.launch {
            var contacto= withContext(Dispatchers.IO){
                db.contactoDao().getById(id.value!!)
            }
            nombre.value=contacto.nombre
            telefono.value=contacto.tel
        }
    }


}