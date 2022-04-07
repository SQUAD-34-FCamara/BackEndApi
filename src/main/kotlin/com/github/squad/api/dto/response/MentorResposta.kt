package com.github.squad.api.dto.response

import com.github.squad.api.enums.ESPECIALIDADES

data class MentorResposta (
    val id: Long,
    val nome: String,
    val email: String,
    val especialidades: List<ESPECIALIDADES>,
    val linkLinkedin: String,
        )
