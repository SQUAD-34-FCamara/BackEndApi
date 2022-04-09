package com.github.squad.api.repository

import com.github.squad.api.model.Agendamento
import org.springframework.data.jpa.repository.JpaRepository

interface AgendamentoRepository : JpaRepository<Agendamento, Long> {

}
