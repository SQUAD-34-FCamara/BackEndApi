package com.github.squad.api.controller

import com.github.squad.api.dto.request.AgendamentoRequest
import com.github.squad.api.extension.toModel
import com.github.squad.api.service.AgendamentoService
import com.github.squad.api.service.MentorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agendamento")
class AgendamentoController(
    private val mentorService: MentorService,
    private val agendamentoService: AgendamentoService
) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun criarData(@RequestBody agendamento: AgendamentoRequest){
        val mentor = mentorService.getMentorById(agendamento.mentorId)
//        agendamentoService.save(agendamento.toModel(mentor))
        mentorService.updateAgendamento(mentor, agendamento.toModel(mentor))
    }

}