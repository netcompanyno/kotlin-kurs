package com.netcompany.java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * In general, you want to create unchecked exception, by extending {@link RuntimeException}.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find thing")
class ThingNotFoundException(message: String) : RuntimeException(message)
