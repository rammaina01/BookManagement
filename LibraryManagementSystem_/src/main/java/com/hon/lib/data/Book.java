package com.hon.lib.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book
{
  @Id
  @GeneratedValue
  private int    bookId;
  private String bookName;
  private String bookTitle;
  private String bookAuthor;
  private double bookPrice;

  public Book()
  {
  }

  public Book(int bookId, String bookName, String bookTitle, String bookAuthor, double bookPrice)
  {
    this.bookId = bookId;
    this.bookName = bookName;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
    this.bookPrice = bookPrice;
  }

  public int getBookId()
  {
    return bookId;
  }

  public String getBookName()
  {
    return bookName;
  }

  public String getBookTitle()
  {
    return bookTitle;
  }

  public String getBookAuthor()
  {
    return bookAuthor;
  }

  public double getBookPrice()
  {
    return bookPrice;
  }

  public void setBookId(int bookId)
  {
    this.bookId = bookId;
  }

  public void setBookName(String bookName)
  {
    this.bookName = bookName;
  }

  public void setBookTitle(String bookTitle)
  {
    this.bookTitle = bookTitle;
  }

  public void setBookAuthor(String bookAuthor)
  {
    this.bookAuthor = bookAuthor;
  }

  public void setBookPrice(double bookPrice)
  {
    this.bookPrice = bookPrice;
  }

}
