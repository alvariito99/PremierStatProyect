package com.example.premierstats

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipo(
    val id: Int,
    val nombre: String,
    val liga: String,
    val estadio: String,
    val imagen: String
) : Parcelable
