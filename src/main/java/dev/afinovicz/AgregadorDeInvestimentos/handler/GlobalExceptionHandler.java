package dev.afinovicz.AgregadorDeInvestimentos.handler;

import dev.afinovicz.AgregadorDeInvestimentos.exception.ErrorResponse;
import dev.afinovicz.AgregadorDeInvestimentos.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
