package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.AtualizaTopicoInput
import br.com.mulhermarav.forum.dto.NovoTopicoInput
import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.exception.NotFoundException
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

    fun listarTopicosPorCurso(id: Long): List<TopicoOutput> {
        println("listando tópicos por curso")

        return topicos.filter {
            it.curso.id == id
        }.map {
            mapper.modelToOutput(it)
        }
    }

    fun listarTopicosPorAutor(id: Long): List<TopicoOutput> {
        println("listando tópicos por autor")

        return topicos.filter {
            it.autor.id == id
        }.map {
            mapper.modelToOutput(it)
        }
    }

    fun buscarPorId(id: Long): TopicoOutput =
        mapper.modelToOutput(buscarTopico(id))

    fun buscarTopico(id: Long): Topico {
        println("buscando tópico por id")

        return topicos.firstOrNull { it.id == id }
            ?: throw NotFoundException("Tópico não encontrado")
    }

    fun cadastrar(input: NovoTopicoInput): TopicoOutput {
        println("cadastrando tópico")

        val topico = mapper.inputToModel(input)
            .copy(
                id = topicos.size.toLong() + 1
            )

        topicos = topicos.plus(topico)

        return mapper.modelToOutput(topico)
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

    fun atualizar(input: AtualizaTopicoInput): TopicoOutput {
        println("atualizando tópico")

        val topico = buscarTopico(input.id)
            .copy(
                id = input.id,
                titulo = input.titulo,
                mensagem = input.mensagem
            )

        salvar(topico)

        return mapper.modelToOutput(topico)
    }

    fun deletar(id: Long) {
        println("deletando tópico")

        topicos = topicos.minus(
            buscarTopico(id)
        )
    }
}