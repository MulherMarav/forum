package br.com.mulhermarav.forum.dto.input

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class AtualizaTopicoInput(
    @field:NotNull
    @field:Positive
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 300)
    val mensagem: String,
)
