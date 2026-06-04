package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {

    private String message;
    private int status;
    private LocalDateTime dateTime;

    public ApiExceptionResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.dateTime = LocalDateTime.now();
    }
}