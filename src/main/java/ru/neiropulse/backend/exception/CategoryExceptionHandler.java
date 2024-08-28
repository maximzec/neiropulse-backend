package ru.neiropulse.backend.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.neiropulse.backend.controller.CategoryController;
import ru.neiropulse.backend.service.CategoryService;

@ControllerAdvice
@Slf4j
public class CategoryExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
