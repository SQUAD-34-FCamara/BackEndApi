package com.github.squad.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hi")
class Hello {
    @GetMapping()
    fun hi(): String {
        return "Hello World!"
    }
}