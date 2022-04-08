package com.github.squad.api.dto.mapper

//import com.github.squad.api.dto.request.MentorRequest
//import com.github.squad.api.enums.Especialidade
//import com.github.squad.api.model.MentorModel
//import com.github.squad.api.service.MentorService
//import org.springframework.stereotype.Component
//
//@Component
//class MentorFormMapper(
//): Mapper<MentorRequest, MentorModel> {
//    override fun map(t: MentorRequest): MentorModel {
//        return MentorModel(
//            nome = t.nome,
//            email = t.email,
//            senha = t.senha,
//            especialidades = findEspecialidadeByEnum(t.especialidades),
//            linkLinkedin = t.linkLinkedin,
//            linkMeet = t.linkMeet,
//        )
//    }
//}
//
//fun findEspecialidadeByEnum(t: List<String>): Set<Especialidade> {
//    var skills = setOf<Especialidade>()
//    t.forEach {
//        when(it) {
//            "FRONTEND" -> skills = skills.plus(Especialidade.FRONTEND)
//            "BACKEND" -> skills = skills.plus(Especialidade.BACKEND)
//            "MOBILE" -> skills = skills.plus(Especialidade.MOBILE)
//            "DATASCIENCE" -> skills = skills.plus(Especialidade.DATASCIENCE)
//            "MACHINELEARNING" -> skills = skills.plus(Especialidade.MACHINELEARNING)
//            "BIGDATA" -> skills = skills.plus(Especialidade.BIGDATA)
//            "DEVOPS" -> skills = skills.plus(Especialidade.DEVOPS)
//            "CLOUD" -> skills = skills.plus(Especialidade.CLOUD)
//            "BLOCKCHAIN" -> skills = skills.plus(Especialidade.BLOCKCHAIN)
//            "DESIGN" -> skills = skills.plus(Especialidade.DESIGN)
//        }
//    }
//    return skills
//}