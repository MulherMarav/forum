package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.input.NovoCursoInput
import br.com.mulhermarav.forum.dto.output.CursoOutput
import br.com.mulhermarav.forum.exception.NotFoundException
import br.com.mulhermarav.forum.model.Curso
import br.com.mulhermarav.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(
    private val repository: CursoRepository
) {

    fun buscarPorId(id: Long): CursoOutput {
        println("buscando curso por id")

        return buscarCurso(id).let {
            CursoOutput(
                id = it.id,
                nome = it.nome,
                categoria = it.categoria
            )
        }
    }

    fun buscarCurso(id: Long): Curso {
        println("buscando curso por id")

        return repository.findById(id).orElseThrow {
            throw NotFoundException("curso não encontrado")
        }
    }

    fun listar(): List<CursoOutput> {
        println("listando cursos")

        return repository.findAll()
            .map {
                CursoOutput(
                    id = it.id,
                    nome = it.nome,
                    categoria = it.categoria
                )
            }
    }

    fun cadastrar(input: NovoCursoInput): CursoOutput {
        println("cadastrando curso")

        val curso = Curso(
            nome = input.nome,
            categoria = input.categoria
        )

        return repository.save(curso).let {
            CursoOutput(
                id = it.id,
                nome = it.nome,
                categoria = it.categoria
            )
        }
    }
}