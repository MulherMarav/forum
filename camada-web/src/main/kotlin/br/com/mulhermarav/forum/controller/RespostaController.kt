package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.AtualizaRespostaInput
import br.com.mulhermarav.forum.dto.NovoRespostaInput
import br.com.mulhermarav.forum.dto.RespostaOutput
import br.com.mulhermarav.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(
    private val service: RespostaService
) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<RespostaOutput> {
        return service.listar(id)
    }

    @GetMapping("/{respostaId}")
    fun buscarPorId(@PathVariable id: Long, @PathVariable respostaId: Long
    ): RespostaOutput {
        return service.buscarPorId(id, respostaId)
    }

    @PostMapping
    fun cadastrar(uriBuilder: UriComponentsBuilder, @PathVariable id: Long,
                  @RequestBody @Valid input: NovoRespostaInput
    ): ResponseEntity<RespostaOutput> {
        val output = service.cadastrar(id, input)
        val uri = uriBuilder.path("/topicos/${id}/respostas/${id}")
            .build().toUri()

        return ResponseEntity.created(uri).body(output)
    }

    @PutMapping
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid input: AtualizaRespostaInput
    ): ResponseEntity<RespostaOutput> {
        val output = service.atualizar(id, input)

        return ResponseEntity.ok().body(output)
    }

    @DeleteMapping("/{respostaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long, @PathVariable respostaId: Long) {
        service.deletar(id, respostaId)
    }
}