package com.ycz.service;

import java.util.List;

import com.ycz.pojo.Book;

public interface BookService {

    List<Book> queryBooksPaged(Integer page,Integer pageSize);

    int countBooks();

}
