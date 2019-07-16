package com.hon.lib.repository;

import com.hon.lib.data.User;
import org.springframework.data.repository.CrudRepository;

public interface IUsersRepository extends CrudRepository<User,Integer>
{
}
