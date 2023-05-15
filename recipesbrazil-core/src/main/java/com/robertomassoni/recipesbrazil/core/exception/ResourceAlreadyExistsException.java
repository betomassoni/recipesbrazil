package com.robertomassoni.recipesbrazil.core.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends ApiException {

    public ResourceAlreadyExistsException(final String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public ResourceAlreadyExistsException() {
        super(HttpStatus.CONFLICT);
    }
}
