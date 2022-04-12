package com.github.squad.api.extension

import com.github.squad.api.dto.request.AgendamentoRequest
import com.github.squad.api.dto.request.AlunoReq
import com.github.squad.api.dto.request.EmailRequest
import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.AlunoResponseId
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.MentorRespostaId
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.enums.Especialidade
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Aluno
import com.github.squad.api.model.Email
import com.github.squad.api.model.Mentor
import org.springframework.data.domain.Page
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern

fun Mentor.toResponse(): MentorResposta{
    return MentorResposta(
            id = this.id!!,
            nome = this.nome,
            email = this.email,
            especialidades = this.especialidades!!,
            linkImage = this.linkImage
    )
}

fun Mentor.toResponseId(): MentorRespostaId {
    return MentorRespostaId(
        id = this.id!!,
        nome = this.nome,
        email = this.email,
        especialidades = this.especialidades!!,
        agendamentos = this.agendamentos as MutableList<Agendamento>,
        linkImage = this.linkImage,
        linkTeams = this.linkTeams
    )
}

fun AgendamentoRequest.toModel(mentor: Mentor, aluno: Aluno): Agendamento {
    return Agendamento(
        data = changeStringToLocalDateTime(this.data),
        status = true,
        mentor = mentor,
        aluno = aluno
    )
}

fun AlunoReq.toModel(): Aluno {
    return Aluno(
        nome = this.nome,
        email = this.email,
    )
}

fun Aluno.toRespones(): AlunoResponseId {
    return AlunoResponseId(
        id = this.id!!,
        nome = this.nome!!,
        email = this.email!!,
        agendamentosAluno = this.agendamentosAluno as MutableList<Agendamento>
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

fun EmailRequest.toModel(agendamento: Agendamento): Email {
    val nomeMentor = agendamento.mentor?.nome
    val linkTeams = agendamento.mentor?.linkTeams
    val emailMentor = agendamento.mentor?.email
    val dataFormat: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm")
    val data = agendamento.data?.format(dataFormat)
    val dataEma =  data?.split("|")?.get(0)
    val hora = data?.split("|")?.get(1)
    return Email(
        toAluno = this.toAluno,
        toMentor = emailMentor,
        nameAluno = this.nameAluno,
        data = dataEma,
        hora = hora,
        withAttachment = this.withAttachment,
        nameMentor = nomeMentor,
        linkTeams = linkTeams,
    )
}

fun EmailRequest.toAlunoReq(): AlunoReq {
    return AlunoReq(
        nome = this.nameAluno,
        email = this.toAluno
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

