package com.example.premierstats.adapter

import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.premierstats.Equipo
import com.example.premierstats.FavItemListFragment

import com.example.premierstats.FavoriteManager
import com.example.premierstats.ItemListFragmentDirections
import com.example.premierstats.R
import com.example.premierstats.databinding.ItemEquiposBinding

class ViewOlder(view: View ) : RecyclerView.ViewHolder(view) {
    private val binding = ItemEquiposBinding.bind(view)

    fun render(
        equipoModel: Equipo,
        onClickListener: (Equipo) -> Unit,
        onFavoriteClickListener: (Equipo) -> Unit,
        onComentarioClickListener: (Equipo) -> Unit

    ) {
        binding.tvEquipoName.text = equipoModel.nombre
        binding.tvEquipoLiga.text = equipoModel.liga
        binding.tvEquipoEstadio.text = equipoModel.estadio
        Glide.with(binding.ivEquipo.context).load(equipoModel.imagen).into(binding.ivEquipo)

        binding.informaciondetallada.setOnClickListener {
            onClickListener(equipoModel)

        }

        val isFavorite = FavoriteManager.listaFavoritos.contains(equipoModel)
        binding.ivFavoritos.setImageResource(if (isFavorite) R.drawable.ic_favourite else R.drawable.ic_not_favouriter)

        binding.ivFavoritos.setOnClickListener {
            if (isFavorite) {

                FavoriteManager.eliminarFavorito(equipoModel)
                binding.ivFavoritos.setImageResource(R.drawable.ic_not_favouriter)
            } else {
                FavoriteManager.agregarFavorito(equipoModel)
                binding.ivFavoritos.setImageResource(R.drawable.ic_favourite)
            }
            onFavoriteClickListener(equipoModel)
        }
        binding.ivComentarios.setOnClickListener {
            onComentarioClickListener(equipoModel)
        }
    }
}
