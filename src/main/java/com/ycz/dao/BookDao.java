package com.ycz.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycz.pojo.Book;
import com.ycz.pojo.Lend;

@Repository
public class BookDao {
    
    @Autowired
    private SqlSessionTemplate sst;

    public List<Book> queryBooksPaged(Map<String, Object> map) {
        return sst.selectList("books.queryBooksPaged",map);
    }

    public int countBooks(Map<String, Object> map) {
        return sst.selectList("books.countBooks",map).size();
    }

    public Book queryBook(long bookId) {
        return sst.selectOne("books.queryBook",bookId);
    }

    public void addBook(Book book) {
        sst.insert("books.addBook",book);
    }

    public void editBook(Book book) {
        sst.update("books.editBook",book);      
    }

    public void deleteBook(long bookId) {
        sst.delete("books.deleteBook",bookId);
    }

    public List<Book> queryAllBooks() {
        return sst.selectList("books.queryAllBooks");
    }

    public List<Lend> queryBookLends(long readerId) {
        return sst.selectList("books.queryBookLends",readerId);
    }

    public void returnBook(Book book) {
        sst.update("books.bookNumAddOne",book);
    }

    public void lendBook(Book book) {
        sst.update("books.bookNumAddOne",book);
    }

}
