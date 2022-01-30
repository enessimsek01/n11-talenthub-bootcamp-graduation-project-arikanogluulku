package com.n11.loanapplication.gen.exception;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private String detail;
    private LocalDate date;

    public ExceptionResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
        this.date = LocalDate.now();
    }
}
