package com.github.squad.api.exception

class NotFoundException(override val message: String, val errorCode: String): Exception()  {
}