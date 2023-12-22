package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.CursoOutput
import br.com.mulhermarav.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(
    private var cursos: List<Curso> = ArrayList()
) {
    init {
        cursos = mutableListOf(
            Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            Curso(
                id = 2,
                nome = "Java",
                categoria = "Programação"
            ),
            Curso(
                id = 3,
                nome = "HTML e CSS",
                categoria = "Front-end"
            )
        )
    }

    fun buscarPorId(id: Long): CursoOutput {

        return buscarCurso(id).let {
            CursoOutput(
                nome = it.nome,
                categoria = it.categoria
            )
        }
    }

    fun buscarCurso(id: Long): Curso {
        println("buscando curso por id")

        return cursos.first { it.id == id }
    }

    fun listar(): List<CursoOutput> {

        return cursos.map {
            CursoOutput(
                nome = it.nome,
                categoria = it.categoria
            )
        }
    }
}