package com.github.squad.api.controller

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.squad.api.dto.request.MentorRequest
import com.github.squad.api.dto.response.MentorResposta
import com.github.squad.api.dto.response.MentorRespostaId
import com.github.squad.api.dto.response.PageResponse
import com.github.squad.api.extension.toPageResponse
import com.github.squad.api.extension.toResponse
import com.github.squad.api.extension.toResponseId
import com.github.squad.api.service.MentorService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@CrossOrigin
@RequestMapping("/api/v1/mentores")
class MentorController(private val mentorService: MentorService) {
    @GetMapping("/{id}")
    fun getMentor(@PathVariable id: Long): MentorRespostaId {
        return mentorService.getMentorById(id).toResponseId()
    }
//    @JsonIgnore
    @GetMapping()
    fun listarMentores(@RequestParam especialidade: String? ,@PageableDefault(page = 0,size = 10)
            paginacao: Pageable ):
                PageResponse<MentorResposta> {
                return mentorService.listarMentores(paginacao, especialidade).map{
                    it.toResponse()
                }.toPageResponse()
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarMentor(@RequestBody @Valid mentorReq: MentorRequest) {
        mentorService.salvarMentor(mentorReq)
    }
}