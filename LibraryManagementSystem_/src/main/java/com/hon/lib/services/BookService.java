package com.hon.lib.services;

import java.util.List;

import com.hon.lib.data.Book;
import com.hon.lib.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService
{

  @Autowired
  private IBookRepository repository;

  public List<Book> getAllBooks()
  {
    return (List<Book>) repository.findAll();
  }

  public void addBook(Book book)
  {
    repository.save(book);
  }
}
