package com.github.squad.api.dto.response

import com.github.squad.api.model.Agendamento

data class AlunoResponseId (
    val id: Long,
    val nome: String,
    val email: String,
    val agendamentosAluno: MutableList<Agendamento>,
)
