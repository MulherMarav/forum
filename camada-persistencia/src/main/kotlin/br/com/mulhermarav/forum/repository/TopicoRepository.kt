package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoId(cursoId: Long): List<Topico>
    fun findByAutorId(autorId: Long): List<Topico>
}