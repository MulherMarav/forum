package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository: JpaRepository<Resposta, Long> {
}