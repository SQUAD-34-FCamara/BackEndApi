package com.github.squad.api.dto.response

import com.github.squad.api.model.EspecialidadeModel

data class MentorResposta (
    val id: Long,
    val nome: String,
    val email: String,
    val especialidades: MutableList<EspecialidadeModel>,
    val linkLinkedin: String,
        )
