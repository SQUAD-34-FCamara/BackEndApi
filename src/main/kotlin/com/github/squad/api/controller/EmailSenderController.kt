package com.github.squad.api.controller

import com.github.squad.api.dto.request.EmailRequest
import com.github.squad.api.extension.toModel
import com.github.squad.api.model.Agendamento
import com.github.squad.api.model.Email
import com.github.squad.api.repository.AgendamentoRepository
import com.github.squad.api.service.AgendamentoService
import com.github.squad.api.service.EmailSenderService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller
class EmailSenderController(private val emailSenderService: EmailSenderService,
                            private val agendamentoService: AgendamentoService
                            ) {
    @PostMapping("/mail/send/{id}")
    fun sendEmail(@PathVariable id: Int, @RequestBody mail: EmailRequest): ResponseEntity<Void> {
        val agendamento: Agendamento = agendamentoService.getAgendamentoById(id)
        emailSenderService.sendMail(mail.toModel(agendamento))
        agendamentoService.updateStatus(agendamento)
        return ResponseEntity.noContent().build()
    }
}