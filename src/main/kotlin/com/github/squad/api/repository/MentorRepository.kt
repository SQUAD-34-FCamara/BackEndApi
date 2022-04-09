package com.github.squad.api.repository

import com.github.squad.api.model.Mentor
import org.springframework.data.jpa.repository.JpaRepository

interface MentorRepository : JpaRepository<Mentor, Long> {

}
