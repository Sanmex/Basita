package com.example.basita


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basita.adapter.ContactoAdapter
import com.example.basita.config.Constantes
import com.example.basita.databinding.ActivityMainBinding
import com.example.basita.ui.FormularioActivity
import com.example.basita.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       //inicializar view model
        //todo enlaza modelo y live data
        viewModel=ViewModelProvider(this).get()
        viewModel.iniciar()

      binding.myrecicler.apply {
         layoutManager=LinearLayoutManager(applicationContext)
      }
       //observer lista contactos,cada vez que la lista cambie de valor el observer lo actualiza
        viewModel.contactosList.observe(this, {
            binding.myrecicler.adapter=ContactoAdapter(it)
        })
        binding.flobot.setOnClickListener {
            val intent= Intent(this,FormularioActivity::class.java)
            //con constantes para diferenciar los click del item y del floating
            intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_INSERTAR)
            startActivity(intent)
        }
    }
}