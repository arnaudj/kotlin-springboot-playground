package com.arnaudj.sbplaygnd.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ControllersAdvice {
    @ResponseBody
    @ExceptionHandler(ElementNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun myelementNotFoundHandler(ex: ElementNotFoundException): String {
        return ex.message ?: ""
    }
}