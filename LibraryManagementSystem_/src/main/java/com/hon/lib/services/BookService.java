package com.hon.lib.services;

import java.util.List;

import com.hon.lib.data.Book;
import com.hon.lib.repository.IBookRepository;
import com.hon.lib.repository.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService
{

  @Autowired
  private IBookRepository repository;

  public List<Book> getAllBooks()
  {
    return (List<Book>) repository.findAll();
  }

  @Override
  public Book getBookById(Integer userId)
  {
    Book book = repository.findById(userId).get();
    return book;
  }

  @Override
  public void addBook(Book book)
  {
    repository.save(book);
  }

  @Override
  public void addBooks(List<Book> books)
  {
    repository.saveAll(books);
  }

  @Override
  public void updateBook(Book book)
  {
    repository.save(book);
  }

  @Override
  public void deleteBook(Integer bookId)
  {
    repository.delete(getBookById(bookId));
  }
}
