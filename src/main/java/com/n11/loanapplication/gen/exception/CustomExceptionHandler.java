package com.n11.loanapplication.gen.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);

        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);
        ExceptionResponse exceptionResponse = new ExceptionResponse(message,description);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> userNotFound(UserNotFound userNotFound){
        String detail = userNotFound.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse("User Not Found." , detail);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CreditNotFound.class)
    public ResponseEntity<?> userNotFound(CreditNotFound creditNotFound){
        String detail = creditNotFound.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse("Credit Not Found." , detail);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}
