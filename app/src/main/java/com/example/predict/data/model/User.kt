package com.example.predict.data.model
data class User(
    val nombrE_USUARIO: String,
    val posicioN_ANNO: Any,
    val posicioN_MES: Any,
    val puntuacioN_ANNIO: Any,
    val puntuacioN_MES: Any
) : Comparable<User> {

    override fun compareTo(other: User): Int {
        // Comparar usuarios basados en la puntuación anual (de mayor a menor)
        val thisPuntuacionAnual = this.puntuacioN_ANNIO?.toString()?.toIntOrNull() ?: 0
        val otherPuntuacionAnual = other.puntuacioN_ANNIO?.toString()?.toIntOrNull() ?: 0

        return otherPuntuacionAnual - thisPuntuacionAnual
    }
}
