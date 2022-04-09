package com.github.squad.api.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class MentorRequest (
    @field:NotEmpty(message = "O Nome deve ser informado")
    var nome: String,
    @field:Email(message = "O Email deve ser informado")
    var email: String,
    var especialidades: List<String>?,
    var linkTeams: String?,
    var linkImage: String?
)
