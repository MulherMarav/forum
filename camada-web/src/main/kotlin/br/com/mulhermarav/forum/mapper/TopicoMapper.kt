package br.com.mulhermarav.forum.mapper

import br.com.mulhermarav.forum.dto.RespostaOutput
import br.com.mulhermarav.forum.dto.TopicoInput
import br.com.mulhermarav.forum.dto.TopicoOutput
import br.com.mulhermarav.forum.model.Topico
import br.com.mulhermarav.forum.service.CursoService
import br.com.mulhermarav.forum.service.TopicoService
import br.com.mulhermarav.forum.service.UsuarioService
import org.springframework.stereotype.Component
import kotlin.random.Random.Default.nextLong

@Component
class TopicoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<Topico, TopicoInput, TopicoOutput> {

    override fun inputToModel(input: TopicoInput): Topico {
        return Topico(
            titulo = input.titulo,
            mensagem = input.mensagem,
            curso = cursoService.buscarPorId(input.cursoId),
            autor = usuarioService.buscarPorId(input.autorId)
        )
    }

    override fun modelToOutput(model: Topico): TopicoOutput {
         val topico = TopicoOutput(
            id = model.id,
            titulo = model.titulo,
            mensagem = model.mensagem,
            dataCriacao = model.dataCriacao,
            status = model.status
        )

        val respostas = model.respostas.map {
            RespostaOutput(
                id = model.id,
                mensagem = model.mensagem,
                topicoId = topico.id,
                topicoTitulo = topico.titulo,
                solucao = it.solucao
            )
        }

        return topico.copy(
            respostas = respostas
        )
    }
}