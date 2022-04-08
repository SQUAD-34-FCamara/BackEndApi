package com.github.squad.api.dto.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}