package com.hon.lib.repository;

import com.hon.lib.data.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book, Integer>
{
}
