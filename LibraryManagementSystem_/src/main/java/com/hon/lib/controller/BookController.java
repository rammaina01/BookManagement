package com.hon.lib.controller;

import java.util.List;

import com.hon.lib.data.Book;
import com.hon.lib.services.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="BooKController",description="Operations to Book")
@RequestMapping(value = "/book")
@RestController
public class BookController
{
  @Autowired
  private BookService bookService;

  @GetMapping(value = "/getAllBooks")
  public List<Book> getAllUsers()
  {
    return bookService.getAllBooks();
  }

  @PostMapping(value = "/addBook")
  public void createUsers(@RequestBody Book book)
  {
    bookService.addBook(book);
  }

}
