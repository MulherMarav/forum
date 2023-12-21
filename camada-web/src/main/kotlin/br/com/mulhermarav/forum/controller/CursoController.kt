package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos/{id}")
class CursoController(
    private val service: TopicoService
) {

    @GetMapping("/topicos")
    fun listar(@PathVariable id: Long): List<TopicoOutput> {
        return service.listarTopicosPorCurso(id)
    }
}