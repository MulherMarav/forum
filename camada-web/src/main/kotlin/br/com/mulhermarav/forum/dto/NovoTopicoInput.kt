package br.com.mulhermarav.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class NovoTopicoInput(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 300)
    val mensagem: String,
    @field:NotNull
    @field:Positive
    val cursoId: Long,
    @field:NotNull
    @field:Positive
    val autorId: Long
)
