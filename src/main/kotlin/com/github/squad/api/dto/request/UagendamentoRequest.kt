package com.github.squad.api.dto.request

data class UagendamentoRequest(
    val mentorId: Long,
    val agendamentoId: Long,
    val data: String,
    val hora: String,
    val emailUsario: String,
    val nomeUsario: String,
)
