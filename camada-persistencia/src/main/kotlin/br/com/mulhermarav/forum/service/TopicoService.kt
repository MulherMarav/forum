package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.input.AtualizaTopicoInput
import br.com.mulhermarav.forum.dto.input.NovoTopicoInput
import br.com.mulhermarav.forum.dto.output.TopicoOutput
import br.com.mulhermarav.forum.exception.NotFoundException
import br.com.mulhermarav.forum.mapper.TopicoMapper
import br.com.mulhermarav.forum.model.Topico
import br.com.mulhermarav.forum.repository.TopicoRepository
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val mapper: TopicoMapper
) {

    fun listar(): List<TopicoOutput> {
        println("listando tópicos")

        return repository.findAll()
            .map {
                mapper.modelToOutput(it)
            }
    }

    fun listarTopicosPorCurso(cursoId: Long): List<TopicoOutput> {
        println("listando tópicos por curso")


        return repository.findByCursoId(cursoId)
            .map {
                mapper.modelToOutput(it)
            }
    }

    fun listarTopicosPorAutor(autorId: Long): List<TopicoOutput> {
        println("listando tópicos por autor")

        return repository.findByAutorId(autorId)
            .map {
                mapper.modelToOutput(it)
            }
    }

    fun buscarPorId(id: Long): TopicoOutput =
        mapper.modelToOutput(buscarTopico(id))

    fun buscarTopico(id: Long): Topico {
        println("buscando tópico por id")

        return repository.findById(id).orElseThrow {
            throw NotFoundException("tópico não encontrado")
        }
    }

    fun cadastrar(input: NovoTopicoInput): TopicoOutput {
        println("cadastrando tópico")

        val topico = mapper.inputToModel(input)

        repository.save(topico)

        return mapper.modelToOutput(topico)
    }

    fun salvar(topico: Topico) {
        println("salvando tópico")

        repository.save(topico)
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

        repository.delete(buscarTopico(id))
    }
}