package com.example.practica1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AboutAdapter (var items: ArrayList<About>) : RecyclerView.Adapter<AboutAdapter.AboutTarjViewHolder>(){

    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class AboutTarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var nombre: TextView
        private var año: TextView
        private var imagen: ImageView

        init {
            nombre = itemView.findViewById(R.id.recycledText1)
            año = itemView.findViewById(R.id.recycledText2)
            imagen = itemView.findViewById(R.id.recicledImage)
        }


        fun bindTarjeta(t: About, onClick: (View) -> Unit) = with(itemView) {
            nombre.setText(t.nombre)
            año.setText(t.año)
            imagen.setImageResource(t.img)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AboutTarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_about, viewGroup, false)
        return AboutTarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: AboutTarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}