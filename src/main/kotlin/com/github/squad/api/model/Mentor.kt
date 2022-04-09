package com.github.squad.api.model


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.github.squad.api.enums.Especialidade
import javax.persistence.*

@Entity(name = "mentor")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Mentor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nome: String,

    @Column
    var email: String,

    @OneToMany(mappedBy = "mentor",cascade = arrayOf(CascadeType.ALL))
    @Column(name = "agendamentos")
    @CollectionTable(name = "mentor_agendamentos", joinColumns = [JoinColumn(name = "mentor_id")])
    @JsonIgnore
    var agendamentos: List<Agendamento> = mutableListOf(),

    @Column(name = "skills")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Especialidade::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "mentor_skills", joinColumns = [JoinColumn(name = "mentor_id")])
    var especialidades: Set<Especialidade>?,

    @Column
    var linkTeams: String? = null,

    @Column
    var linkImage: String? = null,
)
