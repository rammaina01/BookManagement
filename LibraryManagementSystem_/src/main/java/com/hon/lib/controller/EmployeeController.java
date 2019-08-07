package com.hon.lib.controller;

import java.util.List;

import com.hon.lib.parser.EmployeeParser;
import com.hon.lib.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="UserController",description="Operations to users")
@RequestMapping(value = "/employee")
@RestController
public class EmployeeController
{
  @Autowired
  EmployeeService service;

  @ApiOperation(value="view specific employee ")
  @GetMapping(value = "/getEmployeeById/{empId}")
  public EmployeeParser getEmployeeById(@PathVariable String empId)
  {
    return service.getEmployee(empId);
  }
}
