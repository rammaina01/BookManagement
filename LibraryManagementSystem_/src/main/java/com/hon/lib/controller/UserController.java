package com.hon.lib.controller;

import java.util.List;

import com.hon.lib.data.User;
import com.hon.lib.repository.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value="UserController",description="Operations to users")
@RequestMapping(value = "/user")
@RestController
public class UserController
{
  @Autowired
  private IUserService Service;

  @ApiOperation(value="view all available users")
  @GetMapping(value = "/getAllUsers")
  public List<User> getAllUsers()
  {
    return Service.getAllUsers();
  }

  @ApiOperation(value="view specific user ")
  @GetMapping(value = "/getUserById/{userId}")
  public User getUserById(@PathVariable Integer userId)
  {
    return Service.getUserById(userId);
  }

  @ApiOperation(value="Check if specified user available")
  @GetMapping(value = "/isUserAvailable")
  public User isUserAvailable(@RequestParam(value = "userId", required = false) Integer userId)
  {
    if (userId == null)
    {
      return Service.getUserById(1);
    }
    else
    {
      return Service.getUserById(userId);
    }
  }

  @ApiOperation(value="create user")
  @PostMapping(value = "/addUser")
  public void addUser(@RequestBody User user){

    Service.addUser(user);
  }

  @ApiOperation(value="create multiple users")
  @PostMapping(value = "/addUsers")
  public void createUsers(@RequestBody List<User> users)
  {
    Service.addUsers(users);
  }

  @ApiOperation(value="update user")
  @PutMapping(value = "/updateUser")
  public void updateUser(@RequestBody User user){
    Service.updateUser(user);
  }

  @ApiOperation(value="delete user")
  @DeleteMapping(value = "/deleteUser/{userId}")
  public void deleteUser(@PathVariable Integer userId){
    Service.deleteUser(userId);
  }

}
