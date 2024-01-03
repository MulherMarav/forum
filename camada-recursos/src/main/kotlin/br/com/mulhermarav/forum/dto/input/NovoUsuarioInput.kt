package br.com.mulhermarav.forum.dto.input

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class NovoUsuarioInput(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val nome: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val email: String
)
