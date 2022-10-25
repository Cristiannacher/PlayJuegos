package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class GamesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton)
        val toolbar: Toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        var checkBox = arrayListOf<CheckBox>()

        checkBox.add(findViewById(R.id.checkBox1))
        checkBox.add(findViewById(R.id.checkBox2))
        checkBox.add(findViewById(R.id.checkBox3))
        checkBox.add(findViewById(R.id.checkBox4))
        checkBox.add(findViewById(R.id.checkBox5))
        checkBox.add(findViewById(R.id.checkBox6))

        var checkBoxNames = arrayListOf<String>()
        var contador = 0



        fab.setOnClickListener {
            for (i in checkBox) {
                contador++
                if (i.isChecked)
                    if (contador == checkBoxNames.size -2)
                    checkBoxNames.add(i.text.toString() +" y ")
                else if (contador == checkBoxNames.size -1)
                        checkBoxNames.add(i.text.toString())
                else if (contador == checkBoxNames.size)
                        checkBoxNames.add(i.text.toString())
                else checkBoxNames.add(i.text.toString() +", ")
                contador ++
            }
            if (checkBoxNames.size != 0) {
                Snackbar.make(it, "Has elegido" + checkBoxNames, Snackbar.LENGTH_SHORT).show()
            } else Snackbar.make(it, "No has elegido ningun juego", Snackbar.LENGTH_SHORT).show()
            checkBoxNames.clear()
        }
    }
}