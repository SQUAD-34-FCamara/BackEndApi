package com.github.squad.api.repository

import com.github.squad.api.model.Aluno
import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository : JpaRepository<Aluno, Long> {
    fun findByEmailContaining(email: String): List<Aluno>
}


