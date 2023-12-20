package br.com.mulhermarav.forum.dto

import br.com.mulhermarav.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoOutput (
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val status: StatusTopico
)