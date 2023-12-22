package br.com.mulhermarav.forum.service

import br.com.mulhermarav.forum.dto.AtualizaRespostaInput
import br.com.mulhermarav.forum.dto.NovoRespostaInput
import br.com.mulhermarav.forum.dto.RespostaOutput
import br.com.mulhermarav.forum.model.Resposta
import org.springframework.stereotype.Service

@Service
class RespostaService (
    private var respostas: List<Resposta> = ArrayList(),
    private val topicoService: TopicoService,
    private val usuarioService: UsuarioService,
) {

    fun listar(id: Long): List<RespostaOutput> {
        println("listando respostas")

        val topico = topicoService.buscarPorId(id)

        return topico.respostas
    }

    fun cadastrar(id: Long, input: NovoRespostaInput): RespostaOutput {
        println("cadastrando resposta")

        val resposta = Resposta (
            id = respostas.size.toLong() + 1,
            mensagem = input.mensagem,
            autor = usuarioService.buscarUsuario(input.autorId),
            topico = topicoService.buscarTopico(id)
        )

        respostas = respostas.plus(resposta)

        val topico = topicoService.buscarTopico(id)

        topicoService.salvar(
            topico.copy(
                respostas = topico.respostas.plus(resposta)
            )
        )

        return RespostaOutput(
            id = resposta.id,
            mensagem = resposta.mensagem,
            topicoId = resposta.topico.id,
            topicoTitulo = resposta.topico.titulo,
            solucao = resposta.solucao
        )
    }

    fun atualizar(id: Long, input: AtualizaRespostaInput): RespostaOutput {
        println("atualizando resposta")

        val topico = topicoService.buscarTopico(id)

        topico.respostas.first { it.id == input.id }
            .let {
                topicoService.salvar(topico.copy(
                    respostas = topico.respostas.minus(it).plus(
                        it.copy(
                            mensagem = input.mensagem
                        )
                    )
                ))
            }

        val resposta = buscarResposta(input.id)

        respostas = respostas.minus(resposta).plus(
            resposta.copy(
                mensagem = input.mensagem
            )
        )

        return RespostaOutput(
            id = resposta.id,
            mensagem = input.mensagem,
            topicoId = resposta.topico.id,
            topicoTitulo = resposta.topico.titulo,
            solucao = resposta.solucao
        )
    }

    private fun buscarResposta(id: Long): Resposta {
        return respostas.first { it.id == id }
    }

    fun deletar(id: Long, respostaId: Long) {
        println("deletando resposta")

        val topico = topicoService.buscarTopico(id)

        topico.respostas.first { it.id == respostaId }
            .let {
                topicoService.salvar(
                    topico.copy(
                        respostas = topico.respostas.minus(it)
                    )
                )
            }

        val resposta = buscarResposta(id)

        respostas = respostas.minus(resposta)
    }

    fun buscarPorId(id: Long, respostaId: Long): RespostaOutput {
        println("buscando resposta por id")

        val topico = topicoService.buscarPorId(id)

        return topico.respostas.first { it.id == respostaId }
            .let {
                RespostaOutput(
                    id = it.id,
                    mensagem = it.mensagem,
                    topicoId = it.topicoId,
                    topicoTitulo = it.topicoTitulo,
                    solucao = it.solucao
                )
            }
    }
}
