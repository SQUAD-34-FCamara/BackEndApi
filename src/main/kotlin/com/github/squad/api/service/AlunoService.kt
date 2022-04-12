package com.github.squad.api.service

import com.github.squad.api.dto.request.AlunoReq
import com.github.squad.api.enums.Errors
import com.github.squad.api.exception.NotFoundException
import com.github.squad.api.extension.toModel
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Aluno
import com.github.squad.api.repository.AgendamentoRepository
import com.github.squad.api.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(
        private val alunoRepository: AlunoRepository,
        private val agendamentoRepository: AgendamentoRepository
) {
    fun getAlunoById(id: Long): Aluno {
        return alunoRepository.findById(id).orElseThrow {
            NotFoundException(Errors.FC001.message.format(id), Errors.FC001.code)
        }
    }

    fun salvar(aluno: AlunoReq) {
        val alunoModel = aluno.toModel()
        alunoRepository.save(alunoModel)
    }

    fun getAll(email: String): List<Aluno> {
            return alunoRepository.findByEmailContaining(email)

    }

    fun updateAgendamento(agendamento: Agendamento, aluno: Aluno) {
        agendamento.aluno = aluno
        agendamentoRepository.save(agendamento)
    }
    fun salvarReq(aluno: AlunoReq): Aluno {
        val alunoModel = aluno.toModel()
        return alunoRepository.save(alunoModel)
    }

}

