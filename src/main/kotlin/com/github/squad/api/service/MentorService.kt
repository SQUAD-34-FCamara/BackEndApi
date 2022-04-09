package com.github.squad.api.service


import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.enums.Errors
import com.github.squad.api.exception.NotFoundException
import com.github.squad.api.extension.toModel
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Mentor
import com.github.squad.api.repository.MentorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MentorService(private val mentorRepository: MentorRepository) {
    fun listarMentores(paginacao: Pageable): Page<Mentor> {
        return mentorRepository.findAll(paginacao)
    }

    fun salvarMentor(mentorReq: MentorRequest) {
        val mentor = mentorReq.toModel()
         mentorRepository.save(mentor)
    }

    fun getMentorById(id: Long): Mentor {
        return mentorRepository.findById(id).orElseThrow {
            NotFoundException(Errors.FC001.message.format(id), Errors.FC001.code)
        }
    }

    fun updateAgendamento(mentor: Mentor, novoAgendamento: Agendamento) {
        val mentorCopy = mentor.copy(agendamentos = mentor.agendamentos.plus(novoAgendamento))
        mentorRepository.save(mentorCopy)
    }


}
