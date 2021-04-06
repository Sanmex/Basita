

package com.example.basita.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.basita.MainActivity
import com.example.basita.config.Constantes


import com.example.basita.databinding.ActivityFormularioBinding



import com.example.basita.viewmodel.FormularioVM



class FormularioActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFormularioBinding
    private lateinit var viewModel: FormularioVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityFormularioBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //inicializar view model
        viewModel = ViewModelProvider(this).get()
        viewModel.operacion = intent.getStringExtra(Constantes.OPERACION_KEY)!!
        binding.modelo = viewModel
        binding.lifecycleOwner = this
        //observer
        viewModel.operacionexit.observe(this, {
            if (it) {
                mostratMensaje("Operacion exitosa")
                irAlInicio()
            } else {
                mostratMensaje("Ocurrio un error")
            }
        })
        if(viewModel.operacion == Constantes.OPERACION_EDITAR){
            viewModel.id.value=intent.getLongExtra(Constantes.ID_PERSONAL_KEY,0)
            //cargar datos
            viewModel.cargarDatos()
            //ocultar linear layout
            binding.linearEditar.visibility= View.VISIBLE
            binding.btnGuardar.visibility=View.GONE
        }else{
              binding.linearEditar.visibility=View.GONE
              binding.btnGuardar.visibility=View.VISIBLE
        }


    }


    private fun mostratMensaje(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
    }

    private fun irAlInicio() {
        //para activity main
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)//no deja retroceder con el boton atras del fon
        startActivity(intent)
    }
}
