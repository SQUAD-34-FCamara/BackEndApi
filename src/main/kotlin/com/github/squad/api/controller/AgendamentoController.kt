package com.github.squad.api.controller

import com.github.squad.api.dto.request.AgendamentoRequest
import com.github.squad.api.dto.request.AlunoRequest
import com.github.squad.api.extension.toModel
import com.github.squad.api.service.AgendamentoService
import com.github.squad.api.service.AlunoService
import com.github.squad.api.service.MentorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/v1/agendamentos")
class AgendamentoController(
    private val mentorService: MentorService,
    private val agendamentoService: AgendamentoService,
    private val alunoService: AlunoService
) {
    @PostMapping("/mentores")
    @ResponseStatus(HttpStatus.CREATED)
    fun criarData(@RequestBody agendamento: AgendamentoRequest){
        val mentor = mentorService.getMentorById(agendamento.mentorId)
//        val aluno = alunoService.getAlunoById(agendamento.alunoId)
//        agendamentoService.save(agendamento.toModel(mentor))
        mentorService.updateAgendamento(mentor, agendamento.toModel(mentor))
    }

    @PostMapping("/alunos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun marcarMentoria(@PathVariable id: Int, @RequestBody alunoRequest: AlunoRequest) {
        val agendamento = agendamentoService.getAgendamentoById(id)
    }

}