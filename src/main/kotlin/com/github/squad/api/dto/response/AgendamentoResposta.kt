package com.github.squad.api.dto.response

import com.github.squad.api.model.Mentor
import java.time.LocalDateTime

data class AgendamentoResposta (
    val id: Long,
    val data: LocalDateTime?,
    val status: Boolean,
    val mentor: Mentor?
        )
