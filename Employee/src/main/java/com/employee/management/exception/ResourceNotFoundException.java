package com.employee.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String resourceType, String fieldName, String fieldType)
    {

        super(String.format("%s not found with given data %s : %s", resourceType, fieldName, fieldType));
    }
}
