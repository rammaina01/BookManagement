package com.hon.lib.exceptions;

import org.springframework.http.HttpStatus;

public class ApiRequestExceptions extends Exception
{
  public void throwGeneralExceptions() throws Exception
  {
    Exception e = new Exception("Error from General Exception");
    throw e;
  }

  public void throwCustomExceptions() throws CustomException
  {
    CustomException e = new CustomException("Invalid request Body", HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST);
    throw e;
  }
}
