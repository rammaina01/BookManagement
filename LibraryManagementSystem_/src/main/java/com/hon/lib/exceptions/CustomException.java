package com.hon.lib.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception
{
  private String message;
  private int status;
  private HttpStatus httpStatus;

  public CustomException(){}
  public CustomException(String message, int status, HttpStatus httpStatus)
  {
    this.message = message;
    this.status = status;
    this.httpStatus = httpStatus;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public int getStatus()
  {
    return status;
  }

  public void setStatus(int status)
  {
    this.status = status;
  }

  public HttpStatus getHttpStatus()
  {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus)
  {
    this.httpStatus = httpStatus;
  }
}
