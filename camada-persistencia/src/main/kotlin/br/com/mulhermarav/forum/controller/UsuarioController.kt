package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.input.NovoUsuarioInput
import br.com.mulhermarav.forum.dto.output.TopicoOutput
import br.com.mulhermarav.forum.dto.output.UsuarioOutput
import br.com.mulhermarav.forum.service.TopicoService
import br.com.mulhermarav.forum.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

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

    @PostMapping
    @Transactional
    fun cadastrar(uriBuilder: UriComponentsBuilder,
                  @RequestBody @Valid input: NovoUsuarioInput
    ): ResponseEntity<UsuarioOutput> {
        val output = usuarioService.cadastrar(input)
        val uri = uriBuilder.path("/usuarios/${output.id}")
            .build().toUri()

        return ResponseEntity.created(uri).body(output)
    }
}