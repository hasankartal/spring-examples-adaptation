package com.haydikodlayalim.exchandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    //http://localhost:8049/car?name=AB
    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Kayit bulunamadi";
    }

    //http://localhost:8049/car?name=1A
    @ExceptionHandler({IllegalArgumentException.class})
    public String illegalArgumentException() {
        return "Yanlış parametre";
    }
}
