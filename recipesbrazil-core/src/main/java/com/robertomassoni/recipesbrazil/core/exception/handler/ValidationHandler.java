package com.robertomassoni.recipesbrazil.core.exception.handler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@AllArgsConstructor
public class ValidationHandler {

    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handle(MethodArgumentNotValidException exception) {
        final var errors = new ArrayList<ValidationError>();
        exception.getBindingResult().getFieldErrors().forEach(e ->
                errors.add(new ValidationError(messageSource.getMessage(e, LocaleContextHolder.getLocale()))));

        return new ResponseEntity(new ExceptionMessage(HttpStatus.BAD_REQUEST, "Validation errors", errors), HttpStatus.BAD_REQUEST);
    }
}
