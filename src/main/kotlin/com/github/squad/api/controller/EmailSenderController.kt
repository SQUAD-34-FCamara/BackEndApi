package com.github.squad.api.controller

import com.github.squad.api.dto.request.EmailRequest
import com.github.squad.api.extension.toAlunoReq
import com.github.squad.api.extension.toModel
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Aluno
import com.github.squad.api.model.Email
import com.github.squad.api.repository.AgendamentoRepository
import com.github.squad.api.service.AgendamentoService
import com.github.squad.api.service.AlunoService
import com.github.squad.api.service.EmailSenderService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/email")
class EmailSenderController(private val emailSenderService: EmailSenderService,
                            private val agendamentoService: AgendamentoService,
                            private val alunoService: AlunoService
                            ) {
    @PostMapping("/send/{id}")
    fun sendEmail(@PathVariable id: Int, @RequestBody mail: EmailRequest): ResponseEntity<Void> {
        val agendamento: Agendamento = agendamentoService.getAgendamentoById(id)
        var alunoNovo: Aluno = alunoService.salvarReq(mail.toAlunoReq())
        emailSenderService.sendMail(mail.toModel(agendamento))
        agendamentoService.updateStatus(agendamento)
        alunoService.updateAgendamento(agendamento, alunoNovo)
        return ResponseEntity.noContent().build()
    }
}