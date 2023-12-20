package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.TopicoInput
import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.mapper.TopicoMapper
import br.com.mulhermarav.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val mapper: TopicoMapper
) {

    fun listar(): List<TopicoOutput> {
        println("listando tópicos")

        return topicos.map {
            mapper.mapOutput(it)
        }
    }

    fun buscarPorId(id: Long): TopicoOutput {
        println("buscando tópico por id")

        val topico = topicos.first { it.id == id }

        return mapper.mapOutput(topico)
    }

    fun cadastrar(input: TopicoInput) {
        println("cadastrando tópico")

        topicos = topicos.plus(
            mapper.mapInput(input)
        )
    }
}