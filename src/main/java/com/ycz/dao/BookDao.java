package com.ycz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycz.pojo.Book;

@Repository
public class BookDao {
    
    @Autowired
    private SqlSessionTemplate sst;

    public List<Book> queryBooksPaged(Integer page, Integer pageSize) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        //¼ÆËã³östartºÍsize
        int start = (page-1)*pageSize;
        int size = pageSize;
        map.put("start",start);
        map.put("size",size);
        return sst.selectList("books.queryBooksPaged",map);
    }

    public int countBooks() {
        return sst.selectList("books.countBooks").size();
    }

}
