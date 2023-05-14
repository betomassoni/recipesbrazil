package com.robertomassoni.recipesbrazil.core.exception.handler;

import com.robertomassoni.recipesbrazil.core.exception.ApiException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private static final String GENERAL_ERROR_MESSAGE = "Internal server error";
    private static final String API_ERROR_MESSAGE = "API internal error";

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(final Exception ex) {
        final var message = Strings.isNotEmpty(ex.getMessage()) ? ex.getMessage() : GENERAL_ERROR_MESSAGE;
        return new ResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiException(final Exception ex) {
        final var httpStatus = ((ApiException) ex).getHttpStatus();
        final var message = Strings.isNotEmpty(ex.getMessage()) ? ex.getMessage() : API_ERROR_MESSAGE;
        final var test= new ApiError(httpStatus, message);
        //return new ResponseEntity(new ApiError(httpStatus, message), httpStatus);
        return new ResponseEntity(test, httpStatus);

    }
}
