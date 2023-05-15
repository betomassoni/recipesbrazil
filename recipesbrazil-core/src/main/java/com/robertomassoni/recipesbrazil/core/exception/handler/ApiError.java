package com.robertomassoni.recipesbrazil.core.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ApiError {
    private HttpStatus status;
    private String timestamp;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.message = message;
    }
}
