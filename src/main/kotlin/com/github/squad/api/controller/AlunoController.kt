package com.github.squad.api.controller

import com.github.squad.api.dto.request.AlunoReq
import com.github.squad.api.dto.response.AlunoResponseId
import com.github.squad.api.extension.toRespones
import com.github.squad.api.service.AlunoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/alunos")
class AlunoController(private val alunoService: AlunoService ) {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun criarAluno(@RequestBody aluno: AlunoReq) {
        alunoService.salvar(aluno)
    }
    @GetMapping()
    fun listarAlunoPorEmail(@RequestParam email: String): List<AlunoResponseId> {
        return alunoService.getAll(email).map {
            it.toRespones()
        }
    }
}