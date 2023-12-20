package br.com.mulhermarav.forum.service

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

    fun buscarPorId(id: Long): Curso {
        println("buscando curso por id")

        return cursos.first { it.id == id }
    }
}