package com.hon.lib.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler
{

  private HttpStatus badRequest = HttpStatus.BAD_REQUEST;
  private HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<ExceptionResponse> generalException(Exception e)
  {
    ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(),internalServerError.value(),internalServerError);
    return new ResponseEntity<>(exceptionResponse, internalServerError);
  }

  @ExceptionHandler(value = {CustomException.class})
  public ResponseEntity<ExceptionResponse> specialException(CustomException e) throws Exception
  {
    ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), badRequest.value(),badRequest);
    return new ResponseEntity<>(exceptionResponse, badRequest);
  }
}
