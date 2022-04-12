package com.github.squad.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*

@Entity(name = "aluno")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Aluno (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String? = null,
    var email: String? = null,

    @OneToMany(mappedBy = "aluno",cascade = arrayOf(CascadeType.ALL))
    @Column(name = "agendamentos_aluno")
    @CollectionTable(name = "aluno_agendamentos", joinColumns = [JoinColumn(name = "aluno_id")])
    @JsonIgnore
    var agendamentosAluno: List<Agendamento> = mutableListOf(),
        )