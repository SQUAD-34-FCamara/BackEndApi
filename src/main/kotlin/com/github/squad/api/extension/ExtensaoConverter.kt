package com.github.squad.api.extension

import com.github.squad.api.dto.request.AgendamentoRequest
import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.enums.Especialidade
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Mentor
import org.springframework.data.domain.Page
import java.time.LocalDateTime

fun Mentor.toResponse(): MentorResposta{
    return MentorResposta(
            id = this.id!!,
            nome = this.nome,
            email = this.email,
            especialidades = this.especialidades!!,
            agendamentos = this.agendamentos as MutableList<Agendamento>,
            linkTeams = this.linkTeams,
            linkImage = this.linkImage
    )
}

fun AgendamentoRequest.toModel(mentor: Mentor): Agendamento {
    return Agendamento(
        data = changeStringToLocalDateTime(this.data),
        status = true,
        mentor = mentor
    )
}

fun MentorRequest.toModel(): Mentor {
    return Mentor(
        nome = this.nome,
        email = this.email,
        especialidades = findEspecialidadeByEnum(this.especialidades!!),
        agendamentos = mutableListOf(),
        linkTeams = this.linkTeams,
        linkImage = this.linkImage
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

fun changeStringToLocalDateTime(data : String) : LocalDateTime {
    val novaData = LocalDateTime.parse(data)
    return novaData
}