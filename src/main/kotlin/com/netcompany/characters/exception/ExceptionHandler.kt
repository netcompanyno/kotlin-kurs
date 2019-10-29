package com.netcompany.characters.exception

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [InvalidDefinitionException::class])
    fun handleException(ex: InvalidDefinitionException): ResponseEntity<Map<String, Any?>> {
        val cause = ex.cause

        /*
         * Dette er en liten hack for å få require i init til å gi
         * riktig feilmelding i frontend.
         * Det finnes sannsynligvis en bedre måte å løse dette på.
         */
        if (cause is IllegalArgumentException) {
            val body = mapOf(
                "code" to 400,
                "message" to cause.message
            )
            return ResponseEntity(body, HttpStatus.BAD_REQUEST)
        }

        throw ex
    }

}
