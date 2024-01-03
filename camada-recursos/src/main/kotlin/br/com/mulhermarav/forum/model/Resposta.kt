package br.com.mulhermarav.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.io.Serializable
import java.time.LocalDateTime

@Entity
data class Resposta(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val topico: Topico,
    @ManyToOne
    val autor: Usuario,
    val solucao: Boolean = false
): Serializable
