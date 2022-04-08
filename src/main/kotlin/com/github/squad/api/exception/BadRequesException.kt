package com.github.squad.api.exception

class BadRequesException(override val message: String, val errorCode: String): Exception() {
}