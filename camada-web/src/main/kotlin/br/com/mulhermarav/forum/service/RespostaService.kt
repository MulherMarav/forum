package br.com.mulhermarav.forum.service

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

    fun cadastrar(id: Long, input: NovoRespostaInput) {
        println("cadastrando resposta")

        val resposta = Resposta (
            id = respostas.size.toLong() + 1,
            mensagem = input.mensagem,
            autor = usuarioService.buscarPorId(input.autorId),
            topico = topicoService.buscarTopico(id)
        )

        respostas = respostas.plus(resposta)

        val topico = topicoService.buscarTopico(id)

        topicoService.salvar(
            topico.copy(
                respostas = topico.respostas.plus(resposta)
            )
        )

    }
}
