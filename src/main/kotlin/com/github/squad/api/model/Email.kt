package com.github.squad.api.model


data class Email(
    val toAluno: String,
    var toMentor: String?,
    val nameAluno: String,
    var nameMentor: String?,
    var linkTeams: String?,
    var data: String?,
    var hora: String?,
    val subject: String = "Squad - Mentoria marcada com sucesso",
    var text: String = "Olá ${nameAluno},\n\n" +
            "A sua reunião com ${nameMentor} foi reservada com sucesso no dia:${data}" +
            "as ${hora}, O link ${linkTeams} para o contanto com o mentor!\n\n" +
            "Vamos!\n",
    val withAttachment: Boolean
)