package com.github.squad.api.dto.request


data class MentorRequest (

    var nome: String,
    var email: String,
    var senha: String,
    var especialidades: List<String>?,
    var linkLinkedin: String,
    var linkMeet: String

)
