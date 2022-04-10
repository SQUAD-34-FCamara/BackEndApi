package com.github.squad.api.dto.request

data class EmailRequest(
    val toAluno: String,
    val toMentor: String?,
    val nameAluno: String,
    val withAttachment: Boolean,
)
