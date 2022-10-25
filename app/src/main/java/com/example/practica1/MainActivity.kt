package com.example.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.aboutToolbar)
        setSupportActionBar(toolbar)

        val newPlayer: Button = findViewById(R.id.NewPlayer)
        newPlayer.setOnClickListener { lanzarNewPlayer() }

        val preferencies: Button = findViewById(R.id.Preferencies)
        preferencies.setOnClickListener { lanzarPreferencies() }

        val games: Button = findViewById(R.id.Play)
        games.setOnClickListener { lanzargames() }

        val about: Button =findViewById(R.id.About)
        about.setOnClickListener { lanzarAbout() }

        val titulo = findViewById<TextView>(R.id.titulo)
        titulo.typeface = ResourcesCompat.getFont(this, R.font.courgette_regular)
    }

    fun lanzarNewPlayer() {
        val i = Intent(this, NewPlayerActivity::class.java)
        startActivity(i)
    }

    fun lanzarPreferencies() {
        val i = Intent(this, PreferenciesActivity::class.java)
        startActivity(i)
    }

    fun lanzargames() {
        val i = Intent(this, GamesActivity::class.java)
        startActivity(i)
    }

    fun lanzarAbout(){
        val i = Intent(this,AboutActivity::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.action_buscar) -> {
                val i = Intent(this,GeneresActivity::class.java)
                startActivity(i)
                return true
            }
            (R.id.action_add) -> {
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}