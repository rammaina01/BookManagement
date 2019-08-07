package com.hon.lib.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hon.lib.parser.EmployeeParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService
{

  public EmployeeParser getEmployee(String empId)
  {
    EmployeeParser employeeParser= apiResponseMapper(getEmployees(empId), EmployeeParser.class);

    return employeeParser;
  }

  private String getEmployees(String empId)
  {
    final String uri = "http://dummy.restapiexample.com/api/v1/employee/"+empId;

    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
    System.out.println(result);
    return result;
  }

  public <T> T apiResponseMapper(String jsonString, Class<T> cls)
  {
    T result = null;

    ObjectMapper mapper = new ObjectMapper();

    try
    {
      result = mapper.readValue(jsonString, cls);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  public static void main(String[] args)
  {
    EmployeeService employeeService =  new EmployeeService();
    EmployeeParser e =employeeService.getEmployee("40817");
    System.out.println("***********"+e.getEmployeeName());

  }


}
