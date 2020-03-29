package com.ycz.service;

import java.util.List;
import java.util.Map;

import com.ycz.pojo.Book;

public interface BookService {

    List<Book> queryBooksPaged(Map<String, Object> map);

    int countBooks(Map<String, Object> map);

    Book queryBook(long bookId);

    void addBook(Book book);


}
