package com.cserny.test.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 09.03.2016.
 */
@ControllerAdvice
public class ControllerExceptionHandler
{
//    @ExceptionHandler
//    public ResponseEntity<String> handleException(Exception ex)
//    {
//        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.I_AM_A_TEAPOT);
//    }
}
