package br.com.mulhermarav.forum.repository

import br.com.mulhermarav.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByEmail(email: String): Usuario
}