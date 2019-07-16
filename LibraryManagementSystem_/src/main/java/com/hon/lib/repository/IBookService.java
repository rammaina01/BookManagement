package com.hon.lib.repository;

import java.util.List;

import com.hon.lib.data.Book;

public interface IBookService
{
  //GET All BOOKS
  List<Book> getAllBooks();

  //GET BOOK BY ID
  Book getBookById(Integer userId);

  //ADD NEW BOOK
  void addBook(Book book);

  //ADD MULTIPLE BOOKS
  void addBooks(List<Book> books);

  //UPDATE BOOK
  void updateBook(Book book);

  //DELETE BOOK
  void deleteBook(Integer bookId);
}
