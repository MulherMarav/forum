package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoId(cursoId: Long): List<Topico>
    fun findByAutorId(autorId: Long): List<Topico>
    fun findByCursoNomeContaining(nomeCurso: String,
                                  paginacao: Pageable): Page<Topico>
}