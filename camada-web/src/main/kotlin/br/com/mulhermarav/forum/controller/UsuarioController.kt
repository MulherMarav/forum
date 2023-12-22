package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.dto.UsuarioOutput
import br.com.mulhermarav.forum.service.TopicoService
import br.com.mulhermarav.forum.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    private val topicoService: TopicoService,
    private val usuarioService: UsuarioService
) {

    @GetMapping
    fun listar(): List<UsuarioOutput> {
        return usuarioService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): UsuarioOutput {
        return usuarioService.buscarPorId(id)
    }

    @GetMapping("/{id}/topicos")
    fun listar(@PathVariable id: Long): List<TopicoOutput> {
        return topicoService.listarTopicosPorAutor(id)
    }
}