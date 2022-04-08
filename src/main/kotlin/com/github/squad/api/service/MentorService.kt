package com.github.squad.api.service


import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.extension.toModel
import com.github.squad.api.model.MentorModel
import com.github.squad.api.repository.MentorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MentorService(private val mentorRepository: MentorRepository) {
    fun listarMentores(paginacao: Pageable): Page<MentorModel> {
        return mentorRepository.findAll(paginacao)
    }

    fun salvarMentor(mentorReq: MentorRequest) {
        val mentor = mentorReq.toModel()
         mentorRepository.save(mentor)
    }



}
