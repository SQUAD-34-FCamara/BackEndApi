package com.github.squad.api.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "agendamento")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Agendamento (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var data: LocalDateTime? = null,
    var status: Boolean? = false,
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    var mentor: Mentor? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    var aluno: Aluno? = null,
)
