package com.netcompany.characters.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageConversionException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [Exception::class])
    fun handleException(exception: Exception): ResponseEntity<String> {
        if (exception is CharacterNotFoundException) {
            throw exception
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.message)
    }

    @ExceptionHandler(value = [HttpMessageConversionException::class])
    fun handleHttpMessageConversionException(exception: HttpMessageConversionException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(exception.message)
    }
}
