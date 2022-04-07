package com.github.squad.api.repository

import com.github.squad.api.model.MentorModel
import org.springframework.data.jpa.repository.JpaRepository

interface MentorRepository : JpaRepository<MentorModel, Long> {

}
