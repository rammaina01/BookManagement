package com.hon.lib.services;

import java.util.List;

import com.hon.lib.data.User;
import com.hon.lib.repository.IUserService;
import com.hon.lib.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
    @Autowired
    private IUsersRepository repository;

    //GET USERS
    public List<User> getAllUsers()
    {
        return (List<User>) repository.findAll();
    }

    //GET USER BY ID
    public User getUserById(Integer userId)
    {
        User user = repository.findById(userId).get();
        return user;
    }

    //ADD USERS
    public void addUsers(List<User> users)
    {
        repository.saveAll(users);
    }

    //ADD USER
    public void addUser(User user)
    {
        repository.save(user);
    }

    //UPDATE
    public void updateUser(User user)
    {
        repository.save(user);
    }

    //DELETE
    public void deleteUser(Integer userId)
    {
        repository.delete(getUserById(userId));
    }


}
