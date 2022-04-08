package com.github.squad.api.model


import com.fasterxml.jackson.annotation.JsonInclude
import com.github.squad.api.enums.Especialidade
import javax.persistence.*

@Entity(name = "mentor_model")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MentorModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nomeCompleto: String,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    var senha: String,

    @Column(name = "especialidades")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Especialidade::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "mentor_especialidades", joinColumns = [JoinColumn(name = "mentor_id")])
    var especialidades: Set<Especialidade>?,

    @Column
    var linkLinkedin: String,

    @Column
    var linkMeet: String? = null
)
