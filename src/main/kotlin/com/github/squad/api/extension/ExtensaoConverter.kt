package com.github.squad.api.extension

import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.model.MentorModel
import org.springframework.data.domain.Page

fun MentorModel.toResponse(): MentorResposta{
    return MentorResposta(
            id = this.id!!,
            nome = this.nome,
            email = this.email,
            especialidades = this.especialidades,
            linkLinkedin = this.linkLinkedin,
    )
}

fun MentorRequest.toModel(): MentorModel {
    return MentorModel(
            nome = this.nome,
            email = this.email,
            especialidades = this.especialidade,
            linkLinkedin = this.linkLinkendin,
            linkMeet = this.LinkMeet,
            senha = this.senha
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        this.content, this.number, this.totalPages, this.totalElements
    )
}