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
  private IUserService userService;

  @ApiOperation(value="view all available users")
  @GetMapping(value = "/getAllUsers")
  public List<User> getAllUsers()
  {
    return userService.getAllUsers();
  }

  @ApiOperation(value="view specific user ")
  @GetMapping(value = "/getUserById/{userId}")
  public User getTopicById(@PathVariable Integer userId)
  {
    return userService.getUserById(userId);
  }

  @ApiOperation(value="Check if specified user available")
  @GetMapping(value = "/isUserAvailable")
  public User isUserAvailable(@RequestParam(value = "userId", required = false) Integer userId)
  {
    if (userId == null)
    {
      return userService.getUserById(1);
    }
    else
    {
      return userService.getUserById(userId);
    }
  }

  @ApiOperation(value="create user")
  @PostMapping(value = "/addUser")
  public void addUser(@RequestBody User user){

    userService.addUser(user);
  }

  @ApiOperation(value="create multiple users")
  @PostMapping(value = "/addUsers")
  public void createUsers(@RequestBody List<User> users)
  {
    userService.addUsers(users);
  }

  @ApiOperation(value="update user")
  @PutMapping(value = "/updateUser")
  public void updateUser(@RequestBody User user){
    userService.updateUser(user);
  }

  @ApiOperation(value="delete user")
  @DeleteMapping(value = "/deleteUser/{userId}")
  public void deleteUser(@PathVariable Integer userId){
    userService.deleteUser(userId);
  }

}
