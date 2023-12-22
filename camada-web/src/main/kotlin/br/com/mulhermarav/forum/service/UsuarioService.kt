package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.UsuarioOutput
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

    fun buscarUsuario(id: Long): Usuario {
        println("buscando usuário por id")

        return usuarios.first { it.id == id }
    }

    fun buscarPorId(id: Long): UsuarioOutput {
        return buscarUsuario(id).let {
            UsuarioOutput(
                nome = it.nome,
                email = it.email
            )
        }
    }

    fun listar(): List<UsuarioOutput> {
        return usuarios.map {
            UsuarioOutput(
                nome = it.nome,
                email = it.email
            )
        }
    }
}