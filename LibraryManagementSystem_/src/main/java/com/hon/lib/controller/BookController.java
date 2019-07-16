package com.hon.lib.controller;

import java.util.List;

import com.hon.lib.data.Book;
import com.hon.lib.repository.IBookService;
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

@Api(value="BookController",description="Operations to Book")
@RequestMapping(value = "/book")
@RestController
public class BookController
{

  @Autowired
  private IBookService Service;

  @ApiOperation(value="view all available books")
  @GetMapping(value = "/getAllBooks")
  public List<Book> getAllBooks()
  {
    return Service.getAllBooks();
  }

  @ApiOperation(value="view specific book ")
  @GetMapping(value = "/getBookById/{userId}")
  public Book getBookById(@PathVariable Integer bookId)
  {
    return Service.getBookById(bookId);
  }

  @ApiOperation(value="Check if specified book available")
  @GetMapping(value = "/isBookAvailable")
  public Book isBookAvailable(@RequestParam(value = "userId", required = false) Integer bookId)
  {
    if (bookId == null)
    {
      return Service.getBookById(1);
    }
    else
    {
      return Service.getBookById(bookId);
    }
  }

  @ApiOperation(value="add book")
  @PostMapping(value = "/addBook")
  public void addBook(@RequestBody Book book)
  {
    Service.addBook(book);
  }

  @ApiOperation(value="add multiple books")
  @PostMapping(value = "/addBooks")
  public void addBooks(@RequestBody List<Book> books)
  {
    Service.addBooks(books);
  }

  @ApiOperation(value="update book")
  @PutMapping(value = "/updateBook")
  public void updateBook(@RequestBody Book book){
    Service.updateBook(book);
  }

  @ApiOperation(value="delete book")
  @DeleteMapping(value = "/deleteBook/{userId}")
  public void deleteBook(@PathVariable Integer userId){
    Service.deleteBook(userId);
  }


}
