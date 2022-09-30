package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentRecordNotFoundException extends Exception{

    public DepartmentRecordNotFoundException(String msg){
        super(msg);
    }
}
