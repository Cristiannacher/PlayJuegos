package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class NewPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)

        val juegos = arrayOf("Telefono 1", "Telefono 2", "Telefono 3", "Telefono 4", "Telefono 5")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, juegos)

        val list_juegos = findViewById(R.id.spinner) as Spinner
        list_juegos.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        list_juegos.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val texto = parent!!.getItemAtPosition((position)).toString()
                Toast.makeText(applicationContext, parent!!.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
                val phone : TextView = findViewById(R.id.phoneText)
                phone.text = texto
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}