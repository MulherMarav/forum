package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.input.NovoUsuarioInput
import br.com.mulhermarav.forum.dto.output.UsuarioOutput
import br.com.mulhermarav.forum.exception.NotFoundException
import br.com.mulhermarav.forum.model.Usuario
import br.com.mulhermarav.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository
) {

    fun buscarUsuario(id: Long): Usuario {
        println("buscando usuário por id")

        return repository.findById(id).orElseThrow {
            throw NotFoundException("usuário não encontrado")
        }
    }

    fun buscarPorId(id: Long): UsuarioOutput {
        return buscarUsuario(id).let {
            UsuarioOutput(
                id = it.id,
                nome = it.nome,
                email = it.email
            )
        }
    }

    fun listar(): List<UsuarioOutput> {
        println("listando usuários")

        return repository.findAll()
            .map {
                UsuarioOutput(
                    id = it.id,
                    nome = it.nome,
                    email = it.email
                )
            }
    }

    fun cadastrar(input: NovoUsuarioInput): UsuarioOutput {
        println("cadastrando usuário")

        val usuario = Usuario(
            nome = input.nome,
            email = input.email
        )

        return repository.save(usuario).let {
            UsuarioOutput(
                id = it.id,
                nome = it.nome,
                email = it.email
            )
        }
    }
}