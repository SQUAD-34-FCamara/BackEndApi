package com.github.squad.api.controller

import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.extension.toPageResponse
import com.github.squad.api.extension.toResponse
import com.github.squad.api.service.MentorService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/mentores")
class MentorController(private val mentorService: MentorService) {
    @GetMapping()
    fun listarMentores(@PageableDefault(page = 0,size = 10) paginacao: Pageable ):
            PageResponse<MentorResposta> {
            return mentorService.listarMentores(paginacao).map{
                it.toResponse()
            }.toPageResponse()
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarMentor(@RequestBody @Valid mentorReq: MentorRequest) {
        mentorService.salvarMentor(mentorReq)
    }
}