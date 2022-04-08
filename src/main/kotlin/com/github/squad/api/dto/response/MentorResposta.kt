package com.github.squad.api.dto.response

import com.github.squad.api.enums.Especialidade


data class MentorResposta (
    val id: Long,
    val nome: String,
    val email: String,
    val especialidades: Set<Especialidade>,
    val linkLinkedin: String
        )
