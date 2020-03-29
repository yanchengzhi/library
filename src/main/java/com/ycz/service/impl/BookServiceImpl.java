package com.ycz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycz.dao.BookDao;
import com.ycz.pojo.Book;
import com.ycz.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookDao bDao;

    @Override
    public List<Book> queryBooksPaged(Map<String, Object> map) {
        return bDao.queryBooksPaged(map);
    }

    @Override
    public int countBooks(Map<String, Object> map) {
        return bDao.countBooks(map);
    }

    @Override
    public Book queryBook(long bookId) {
        return bDao.queryBook(bookId);
    }

    @Override
    public void addBook(Book book) {
        bDao.addBook(book);
    }
    

}
