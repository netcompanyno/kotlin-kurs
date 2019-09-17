package com.netcompany.characters.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception thrown when a requested character can't be found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find character")
class CharacterNotFoundException(message: String) : RuntimeException(message)
