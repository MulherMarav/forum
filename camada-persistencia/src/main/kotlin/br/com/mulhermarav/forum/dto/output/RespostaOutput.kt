package br.com.mulhermarav.forum.dto.output

data class RespostaOutput(
    val id: Long? = null,
    val mensagem: String,
    val topicoId: Long? = null,
    val topicoTitulo: String,
    val solucao: Boolean = false
)
