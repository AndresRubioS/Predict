package com.example.predict.data

data class Predict(
    val active: Boolean,
    val equipO_LOCAL_ID: String,
    val nombrE_EQUIPO_LOCAL: String,
    val nombrE_EQUIPO_VISITANTE: String,
    val logO_EQUIPO_LOCAL: String,
    val logO_EQUIPO_VISITANTE:String,
    val equipO_VISITANTE_ID: String,
    val fecha: String,
    val goleS_EQUIPO_LOCAL: Int,
    val goleS_EQUIPO_VISITANTE: Int,
    val jornadA_ID: String,
    val partidO_ID: String
)