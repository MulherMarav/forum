package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.dto.TopicoPorCategoriaDto
import br.com.mulhermarav.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoId(cursoId: Long): List<Topico>
    fun findByAutorId(autorId: Long): List<Topico>
    fun findByCursoNomeContaining(nomeCurso: String,
                                  paginacao: Pageable): Page<Topico>
    @Query("SELECT new br.com.mulhermarav.forum.dto." +
        "TopicoPorCategoriaDto(curso.categoria, count(t)) " +
        "FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>

    //@Query("SELECT t FROM Topico t WHERE t.respostas IS EMPTY")
    fun findByRespostasIsEmpty(): List<Topico>
}