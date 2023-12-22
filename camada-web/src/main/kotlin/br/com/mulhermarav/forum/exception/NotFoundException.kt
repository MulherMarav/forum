package br.com.mulhermarav.forum.exception

class NotFoundException(
    message: String? = "Not found"
) : RuntimeException(message)