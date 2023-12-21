package br.com.mulhermarav.forum.mapper

interface Mapper<Model, Input, Output> {

    fun inputToModel(input: Input): Model

    fun modelToOutput(model: Model): Output
}