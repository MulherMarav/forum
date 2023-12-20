package br.com.mulhermarav.forum.dto

data class TopicoInput(
    val titulo: String,
    val mensagem: String,
    val cursoId: Long,
    val autorId: Long
)
