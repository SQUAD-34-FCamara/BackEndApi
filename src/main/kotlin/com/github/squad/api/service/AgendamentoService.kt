package com.github.squad.api.service

import com.github.squad.api.model.Agendamento
import com.github.squad.api.repository.AgendamentoRepository
import org.springframework.stereotype.Service

@Service
class AgendamentoService(private val agendamentoRepository: AgendamentoRepository) {
    fun getAgendamentoById(id: Int): Agendamento {
        return agendamentoRepository.findById(id.toLong()).get()
    }

    fun updateStatus(agendamento: Agendamento,) {
        agendamento.status = false
        agendamentoRepository.save(agendamento)
    }

    }
//    fun save(novaData: Agendamento) {
//        agendamentoRepository.save(novaData)
//    }

