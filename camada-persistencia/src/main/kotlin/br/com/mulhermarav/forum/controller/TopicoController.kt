package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.input.AtualizaTopicoInput
import br.com.mulhermarav.forum.dto.input.NovoTopicoInput
import br.com.mulhermarav.forum.dto.output.TopicoOutput
import br.com.mulhermarav.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoOutput> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoOutput {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(uriBuilder: UriComponentsBuilder,
        @RequestBody @Valid input: NovoTopicoInput
    ): ResponseEntity<TopicoOutput> {
        val output = service.cadastrar(input)
        val uri = uriBuilder.path("/topicos/${output.id}").build().toUri()

        return ResponseEntity.created(uri).body(output)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid input: AtualizaTopicoInput
    ): ResponseEntity<TopicoOutput> {
        val output = service.atualizar(input)

        return ResponseEntity.ok().body(output)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}