package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.RespostaInput
import br.com.mulhermarav.forum.dto.RespostaOutput
import br.com.mulhermarav.forum.model.Resposta
import br.com.mulhermarav.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(
    private val service: RespostaService
) {

    @GetMapping
    fun listar(@PathVariable id: Long): List<RespostaOutput> {
        return service.listar(id)
    }

    @PostMapping
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid input: RespostaInput) {
        service.cadastrar(id, input)
    }
}