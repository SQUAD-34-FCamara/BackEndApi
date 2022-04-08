package com.github.squad.api.model


import org.hibernate.Hibernate
import javax.persistence.*

@Entity(name = "mentor_model")
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
    @OneToMany
    var especialidades: MutableList<EspecialidadeModel>,

    @Column
    var linkLinkedin: String,

    @Column
    var linkMeet: String? = null
)
