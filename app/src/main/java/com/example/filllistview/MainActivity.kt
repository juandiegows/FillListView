package com.example.filllistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.filllistview.adapter.UserAdapter
import com.example.filllistview.databinding.ActivityMainBinding
import com.example.filllistview.model.User

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var list : MutableList<User> = mutableListOf(
        User().apply {
            id =1
            nombre = "Juan Diego"
            apellido = "Mejia Maestre"
            edad = 21
        },
        User().apply {
            id =2
            nombre = "Samuel"
            apellido = "Solano Amaya"
            edad = 18
        },
        User().apply {
            id =3
            nombre = "Esteban"
            apellido = "Quintero Amaya"
            edad = 34
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listView.adapter = UserAdapter(list){
            Toast.makeText(this, "Actualizar usuario con id : ${it.id}", Toast.LENGTH_SHORT).show()
        }
    }
}