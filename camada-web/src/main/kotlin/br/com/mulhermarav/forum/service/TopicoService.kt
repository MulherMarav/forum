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
            mapper.modelToOutput(it)
        }
    }

    fun buscarPorId(id: Long): TopicoOutput =
        mapper.modelToOutput(buscarTopico(id))

    fun buscarTopico(id: Long): Topico {
        println("buscando tópico por id")

        return topicos.first { it.id == id }
    }

    fun cadastrar(input: TopicoInput) {
        println("cadastrando tópico")

        topicos = topicos.plus(
            mapper.inputToModel(input)
                .copy(
                    id = topicos.size.toLong() + 1
                )
        )
    }

    fun salvar(topico: Topico) {
        println("salvando tópico")

        topicos = topicos.toMutableList().map {
            if (it.id == topico.id) {
                topico
            } else {
                it
            }
        }
    }
}