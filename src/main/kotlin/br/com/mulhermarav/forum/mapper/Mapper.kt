package br.com.mulhermarav.forum.mapper

interface Mapper<M, I, O> {

    fun mapInput(input: I): M

    fun mapOutput(model: M): O
}