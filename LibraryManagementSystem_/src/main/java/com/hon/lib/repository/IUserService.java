package com.hon.lib.repository;

import java.util.List;

import com.hon.lib.data.User;

public interface IUserService
{
  List<User> getAllUsers();

  User getUserById(Integer userId);

  void addUser(User user);

  void addUsers(List<User> users);

  void updateUser(User user);

  void deleteUser(Integer userId);
}
