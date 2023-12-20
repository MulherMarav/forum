package br.com.mulhermarav.forum.mapper

import br.com.mulhermarav.forum.dto.TopicoInput
import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.model.Topico
import br.com.mulhermarav.forum.service.CursoService
import br.com.mulhermarav.forum.service.UsuarioService
import org.springframework.stereotype.Component
import kotlin.random.Random.Default.nextLong

@Component
class TopicoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<Topico, TopicoInput, TopicoOutput> {

    override fun mapInput(input: TopicoInput): Topico {
        return Topico(
            id = nextLong(),
            titulo = input.titulo,
            mensagem = input.mensagem,
            curso = cursoService.buscarPorId(input.cursoId),
            autor = usuarioService.buscarPorId(input.autorId)
        )
    }

    override fun mapOutput(model: Topico): TopicoOutput {
        return TopicoOutput(
            id = model.id,
            titulo = model.titulo,
            mensagem = model.mensagem,
            dataCriacao = model.dataCriacao,
            status = model.status
        )
    }
}