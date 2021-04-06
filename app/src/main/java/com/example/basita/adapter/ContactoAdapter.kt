package com.example.basita.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basita.R
import com.example.basita.config.Constantes
import com.example.basita.databinding.ItemListBinding
import com.example.basita.models.ContactoE
import com.example.basita.ui.FormularioActivity

//signo interrogacion significa que puede venir vacio
class ContactoAdapter(private val dataSet: List<ContactoE>?) :
    RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {




    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val item : ContactoE? =dataSet?.get(position)
        viewHolder.enlazarItem(item!!)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet!!.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var binding= ItemListBinding.bind(view)
         var contexto=view.context


        fun enlazarItem(c: ContactoE) {

            binding.textviewNombre.text= c.nombre
            binding.telefono.text= c.tel

            binding.root.setOnClickListener {
                val intent=Intent(contexto,FormularioActivity::class.java)
                intent.putExtra(Constantes.OPERACION_KEY,Constantes.OPERACION_EDITAR)
                intent.putExtra(Constantes.ID_PERSONAL_KEY,c.idCon)
                contexto.startActivity(intent)
            }
        }
    }
    }

