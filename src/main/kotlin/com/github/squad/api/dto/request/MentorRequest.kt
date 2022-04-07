package com.github.squad.api.dto.request

import com.github.squad.api.enums.ESPECIALIDADES

data class MentorRequest (
    var nome: String,
    var email: String,
    var senha: String,
    var especialidade: ESPECIALIDADES,
    var linkLinkendin: String,
    var LinkMeet: String
)
