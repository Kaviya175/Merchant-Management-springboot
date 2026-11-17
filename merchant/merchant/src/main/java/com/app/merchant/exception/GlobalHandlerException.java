package com.app.merchant.exception;

import com.app.merchant.model.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidAddressException.class)
    public ResponseEntity<ApplicationError> handleInvalidAddressException(InvalidAddressException e) {
        return new ResponseEntity<>(new ApplicationError("err-001",e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidMobileNoException.class)
    public ResponseEntity<ApplicationError> handleInvalidMobileNoException(InvalidMobileNoException e) {
        return new ResponseEntity<>(new ApplicationError("err-002",e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
