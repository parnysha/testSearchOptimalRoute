package org.example.testovoe.controller;

import org.example.testovoe.JSONSamples.JsonErr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.groupdocs.parser.exceptions.System.IO.FileNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<JsonErr> handleException(FileNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new JsonErr("Файл не найден"));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonErr> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new JsonErr("Страница не найдена"));
    }
}
