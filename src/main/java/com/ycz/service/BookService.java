package com.ycz.service;

import java.util.List;
import java.util.Map;

import com.ycz.pojo.Book;
import com.ycz.pojo.Lend;

public interface BookService {

    List<Book> queryBooksPaged(Map<String, Object> map);

    int countBooks(Map<String, Object> map);

    Book queryBook(long bookId);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(long bookId);

    List<Book> queryAllBooks();

    List<Lend> queryBookLends(long readerId);

    void returnBook(Book book);

    void lendBook(Book book);

}
