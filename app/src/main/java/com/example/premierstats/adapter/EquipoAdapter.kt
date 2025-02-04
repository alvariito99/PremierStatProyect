package com.example.premierstats.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.premierstats.Equipo
import com.example.premierstats.FavoriteManager

import com.example.premierstats.databinding.ItemEquiposBinding

class EquipoAdapter(
    private val listaEquipos: List<Equipo>,
    private val onItemClickListener: (Equipo) -> Unit,
    private val onFavoriteClickListener: (Equipo) -> Unit,
    private val onComentarioClickListener: (Equipo) -> Unit

) : RecyclerView.Adapter<ViewOlder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewOlder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEquiposBinding.inflate(layoutInflater, parent, false)
        return ViewOlder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewOlder, position: Int) {
        val item = listaEquipos[position]
        holder.render(item, onItemClickListener, onFavoriteClickListener, onComentarioClickListener)
    }

    override fun getItemCount(): Int = listaEquipos.size
}


