package com.ycz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycz.dao.BookDao;
import com.ycz.pojo.Book;
import com.ycz.pojo.Lend;
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

    @Override
    public void editBook(Book book) {
        bDao.editBook(book);
    }

    @Override
    public void deleteBook(long bookId) {
        bDao.deleteBook(bookId);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bDao.queryAllBooks();
    }

    @Override
    public List<Lend> queryBookLends(long readerId) {
        return bDao.queryBookLends(readerId);
    }

    @Override
    public void returnBook(Book book) {
         bDao.returnBook(book);
    }

    @Override
    public void lendBook(Book book) {
        bDao.lendBook(book);
    }
    

}
