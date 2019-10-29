package com.netcompany.characters.exception

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [InvalidDefinitionException::class])
    fun handleException(exception: InvalidDefinitionException): ResponseEntity<String> {
        val cause = exception.cause

        // Dette er en liten hack for å få require i init til å fungere.
        // Det finnes sannsynligvis en bedre måte å løse dette på.
        if (cause is IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                    """
                {
                  "code": 500, 
                  "message": "${cause.message}"
                }
            """.trimIndent()
                )
        }

        throw exception
    }

}
