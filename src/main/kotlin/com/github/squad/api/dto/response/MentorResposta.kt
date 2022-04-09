package com.github.squad.api.dto.response

import com.github.squad.api.enums.Especialidade
import com.github.squad.api.model.Agendamento


data class MentorResposta (
    val id: Long,
    val nome: String,
    val email: String,
    val especialidades: Set<Especialidade>,
    val agendamentos: MutableList<Agendamento>,
    val linkTeams: String?,
    val linkImage: String?
        )
