    package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolbar: Toolbar = findViewById(R.id.aboutToolbar)
        setSupportActionBar(toolbar)

        val items = ArrayList<About>()
        items.add(About(R.drawable.image1,R.string.Nombre1,R.string.Año1))
        items.add(About(R.drawable.image2,R.string.Nombre2,R.string.Año2))
        items.add(About(R.drawable.image3,R.string.Nombre3,R.string.Año3))
        items.add(About(R.drawable.image4,R.string.Nombre4,R.string.Año4))
        items.add(About(R.drawable.image5,R.string.Nombre5,R.string.Año5))
        items.add(About(R.drawable.image6,R.string.Nombre6,R.string.Año6))
        items.add(About(R.drawable.image7,R.string.Nombre7,R.string.Año7))

        val recView = findViewById<RecyclerView>(R.id.recycledView)

        recView.setHasFixedSize(true)

        val adaptador = AboutAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            Toast.makeText(this@AboutActivity, ""+ getString(items.get(recView.getChildAdapterPosition(it)).nombre) , Toast.LENGTH_LONG).show()
        }

    }
}