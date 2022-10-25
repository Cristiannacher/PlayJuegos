package com.example.practica1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenersAdapter( var items: ArrayList<Geners>) : RecyclerView.Adapter<GenersAdapter.GenersTarjViewHolder>() {
    lateinit var onClick : (View) -> Unit
    init {
        this.items = items
    }

    class GenersTarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var texto: TextView

        init {
            texto = itemView.findViewById(R.id.txt1)
        }

        fun bindTarjeta(t: Geners, onClick: (View) -> Unit) = with(itemView) {
            texto.setText(t.cadena)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GenersTarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_geners, viewGroup, false)
        return GenersTarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: GenersTarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}