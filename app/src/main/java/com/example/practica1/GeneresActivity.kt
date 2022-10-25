package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class GeneresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres)

        val bottomAppBar: BottomAppBar = findViewById(R.id.bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.menu)

        val chipGroup = findViewById(R.id.chip_group) as ChipGroup
        var option = ""

        chipGroup.setOnCheckedStateChangeListener { group, MutableListId ->
            option = ""
            for(item in MutableListId) {
                val checkedChip = group.findViewById<Chip>(item)
                option += checkedChip.text as String + " "
            }

        }
        val fab: FloatingActionButton = findViewById(R.id.floatingActionButton2)
        fab.setOnClickListener{
            Snackbar.make(it,""+option,Snackbar.LENGTH_SHORT).show()
        }

        val items = ArrayList<Geners>()
        items.add(Geners(R.string.Gener1))
        items.add(Geners(R.string.Gener2))
        items.add(Geners(R.string.Gener3))
        items.add(Geners(R.string.Gener4))
        items.add(Geners(R.string.Gener5))
        items.add(Geners(R.string.Gener6))
        items.add(Geners(R.string.Gener7))
        items.add(Geners(R.string.Gener8))
        items.add(Geners(R.string.Gener9))
        items.add(Geners(R.string.Gener5))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = GenersAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick = {
            Toast.makeText(this@GeneresActivity, ""+ getString(items.get(recView.getChildAdapterPosition(it)).cadena) , Toast.LENGTH_LONG).show()
        }
    }

}