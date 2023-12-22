package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.CursoOutput
import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.service.CursoService
import br.com.mulhermarav.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cursos")
class CursoController(
    private val topicoService: TopicoService,
    private val cursoService: CursoService
) {

    @GetMapping
    fun listar(): List<CursoOutput> {
        return cursoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): CursoOutput {
        return cursoService.buscarPorId(id)
    }

    @GetMapping("/{id}/topicos")
    fun listarTopicosPorCurso(@PathVariable id: Long
    ): List<TopicoOutput> {
        return topicoService.listarTopicosPorCurso(id)
    }
}