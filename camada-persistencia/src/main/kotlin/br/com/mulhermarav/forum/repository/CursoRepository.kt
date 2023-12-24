package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
    fun findByNome(nomeCurso: String): Curso
}