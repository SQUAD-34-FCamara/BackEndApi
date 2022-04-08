package com.github.squad.api.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class MentorRequest (
    @field:NotEmpty(message = "O Nome completo deve ser informado")
    var nomeCompleto: String,
    @field:NotEmpty(message = "O Nome deve ser informado")
    var nome: String,
    @field:Email(message = "O Email deve ser informado")
    var email: String,
    @field:NotEmpty(message = "A senha deve ser informada")
    var senha: String,
    var especialidades: List<String>?,
    @field:NotEmpty(message = "O link do linkedin deve ser informado")
    var linkLinkedin: String,
    var linkMeet: String
)
