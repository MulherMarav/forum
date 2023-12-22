package br.com.mulhermarav.forum.exception.dto

import java.time.LocalDateTime

data class ErrorOutput(
    val message: String?,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val path: String
)
