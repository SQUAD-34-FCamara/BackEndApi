package com.github.squad.api.dto.response

data class PageResponse<T>  (
    var items: List<T>,
    var currentPage: Int,
    var totalPages: Int,
    var totalItems: Long
        )


