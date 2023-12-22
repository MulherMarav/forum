package br.com.mulhermarav.forum.model

import java.time.LocalDateTime

data class Resposta(
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val topico: Topico,
    val autor: Usuario,
    val solucao: Boolean = false
)
