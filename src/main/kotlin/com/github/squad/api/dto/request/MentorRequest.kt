package com.github.squad.api.dto.request

import com.github.squad.api.model.EspecialidadeModel

data class MentorRequest (
    var nome: String,
    var email: String,
    var senha: String,
    var especialidade: MutableList<EspecialidadeModel>,
    var linkLinkendin: String,
    var LinkMeet: String
)
