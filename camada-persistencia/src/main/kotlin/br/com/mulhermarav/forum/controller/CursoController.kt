package br.com.mulhermarav.forum.controller

import br.com.mulhermarav.forum.dto.input.NovoCursoInput
import br.com.mulhermarav.forum.dto.output.CursoOutput
import br.com.mulhermarav.forum.dto.output.TopicoOutput
import br.com.mulhermarav.forum.service.CursoService
import br.com.mulhermarav.forum.service.TopicoService
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

    @PostMapping
    @Transactional
    fun cadastrar(uriBuilder: UriComponentsBuilder,
                  @RequestBody @Valid input: NovoCursoInput
    ): ResponseEntity<CursoOutput> {
        val output = cursoService.cadastrar(input)
        val uri = uriBuilder.path("/cursos/${output.id}")
            .build().toUri()

        return ResponseEntity.created(uri).body(output)
    }
}