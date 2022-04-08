package com.github.squad.api.extension

import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.enums.Especialidade
import com.github.squad.api.model.MentorModel
import org.springframework.data.domain.Page

fun MentorModel.toResponse(): MentorResposta{
    return MentorResposta(
            id = this.id!!,
            nome = this.nome,
            email = this.email,
            especialidades = this.especialidades!!,
            linkLinkedin = this.linkLinkedin,
    )
}

fun MentorRequest.toModel(): MentorModel {
    return MentorModel(
        nomeCompleto = this.nomeCompleto,
        nome = this.nome,
        email = this.email,
        senha = this.senha,
        especialidades = findEspecialidadeByEnum(this.especialidades!!),
        linkLinkedin = this.linkLinkedin
    )
}

fun <T> Page<T>.toPageResponse(): PageResponse<T> {
    return PageResponse(
        this.content, this.number, this.totalPages, this.totalElements
    )
}

fun findEspecialidadeByEnum(t: List<String>): Set<Especialidade> {
    var skills = setOf<Especialidade>()
    t.forEach {
        when(it) {
            "FRONTEND" -> skills = skills.plus(Especialidade.FRONTEND)
            "BACKEND" -> skills = skills.plus(Especialidade.BACKEND)
            "MOBILE" -> skills = skills.plus(Especialidade.MOBILE)
            "DATASCIENCE" -> skills = skills.plus(Especialidade.DATASCIENCE)
            "MACHINELEARNING" -> skills = skills.plus(Especialidade.MACHINELEARNING)
            "BIGDATA" -> skills = skills.plus(Especialidade.BIGDATA)
            "DEVOPS" -> skills = skills.plus(Especialidade.DEVOPS)
            "CLOUD" -> skills = skills.plus(Especialidade.CLOUD)
            "BLOCKCHAIN" -> skills = skills.plus(Especialidade.BLOCKCHAIN)
            "DESIGN" -> skills = skills.plus(Especialidade.DESIGN)
        }
    }
    return skills
}