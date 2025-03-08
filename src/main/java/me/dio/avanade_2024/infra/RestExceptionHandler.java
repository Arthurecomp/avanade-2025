package me.dio.avanade_2024.infra;

import me.dio.avanade_2024.controller.exception.EventFullException;
import me.dio.avanade_2024.controller.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    private ResponseEntity<String> eventNotFoundHandler(EventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
    }

    @ExceptionHandler(EventFullException.class)
    private ResponseEntity<String> eventFullExceptionHandler(EventFullException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event is full");
    }

}
