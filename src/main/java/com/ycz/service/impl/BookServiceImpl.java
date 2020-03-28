package com.ycz.service.impl;

import java.util.List;

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
    public List<Book> queryBooksPaged(Integer page,Integer pageSize) {
        return bDao.queryBooksPaged(page,pageSize);
    }

    @Override
    public int countBooks() {
        return bDao.countBooks();
    }
    

}
