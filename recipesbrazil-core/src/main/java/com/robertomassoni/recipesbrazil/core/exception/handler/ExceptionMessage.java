package com.robertomassoni.recipesbrazil.core.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class ExceptionMessage {
    private HttpStatus status;
    private String timestamp;
    private String message;
    private List<ValidationError> errors;

    public ExceptionMessage(HttpStatus status, String message) {
        this.status = status;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.message = message;
    }

    public ExceptionMessage(HttpStatus status, String message, List<ValidationError> errors) {
        this.status = status;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.message = message;
        this.errors = errors;
    }
}
