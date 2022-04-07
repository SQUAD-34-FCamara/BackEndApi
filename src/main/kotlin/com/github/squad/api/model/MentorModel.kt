package com.github.squad.api.model

import com.github.squad.api.enums.ESPECIALIDADES
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class MentorModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    var senha: String,

    @Column
    var especialidades: List<ESPECIALIDADES>,

    @Column
    var linkLinkedin: String,

    @Column
    var linkMeet: String
)