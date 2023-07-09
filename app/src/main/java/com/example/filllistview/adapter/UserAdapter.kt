package com.example.filllistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.example.filllistview.R
import com.example.filllistview.databinding.ItemUserBinding
import com.example.filllistview.model.User

class UserAdapter(var users: MutableList<User>, var Actualizar: (user : User)-> Unit) : BaseAdapter() {
    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(position: Int): User {
        return users.get(position)
    }

    override fun getItemId(position: Int): Long {
        return users.get(position).id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var user = getItem(position)
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_user, parent, false)
        var binding: ItemUserBinding = ItemUserBinding.bind(view)
        binding.apply {
            user.apply {
                txtNombre.text = nombre
                txtApellido.text = apellido
                txtEdad.text = edad.toString()
                btnEliminar.setOnClickListener {
                    Toast.makeText(root.context, "Eliminar usuario con id : $id", Toast.LENGTH_SHORT).show()
                }
                btnEditar.setOnClickListener {
                    Actualizar(user)
                }
            }
        }

        return view

    }
}