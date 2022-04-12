package com.github.squad.api.repository

import com.github.squad.api.enums.Especialidade
import com.github.squad.api.model.Mentor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MentorRepository : JpaRepository<Mentor, Long> {
    fun findAllByEspecialidadesIn(especialidades: Set<Especialidade>, pageable: Pageable): Page<Mentor>
}
