package com.example.premierstats

object FavoriteManager {
    val listaFavoritos = mutableListOf<Equipo>()

    fun agregarFavorito(equipo: Equipo) {
        if (!listaFavoritos.contains(equipo)) {
            listaFavoritos.add(equipo)
        }
    }

    fun eliminarFavorito(equipo: Equipo) {
        listaFavoritos.remove(equipo)
    }
    fun comentario(equipo: Equipo) {
        listaFavoritos.remove(equipo)
    }
}
