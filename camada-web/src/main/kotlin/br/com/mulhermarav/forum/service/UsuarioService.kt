package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario> = ArrayList()
) {
    init {
        usuarios = mutableListOf(
            Usuario(
                id = 1,
                nome = "Dyane",
                email = "dyane.aaraujo@gmail.com"
            ),
            Usuario(
                id = 2,
                nome = "Guilherme",
                email = "guilherme_raykow@hotmail.com"
            )
        )
    }

    fun buscarPorId(id: Long): Usuario {
        println("buscando usuário por id")

        return usuarios.first { it.id == id }
    }
}