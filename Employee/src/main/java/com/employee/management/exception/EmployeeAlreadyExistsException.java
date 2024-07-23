package com.employee.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends  RuntimeException{

    public EmployeeAlreadyExistsException(String msg)
    {
        super(msg);
    }
}
