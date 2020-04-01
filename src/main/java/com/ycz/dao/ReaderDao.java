package com.ycz.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycz.pojo.Book;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;

@Repository
public class ReaderDao {
    
    @Autowired
    private SqlSessionTemplate sst;

    public List<ReaderInfo> queryReadersPaged(Map<String, Object> map) {
        return sst.selectList("readers.queryReadersPaged",map);
    }

    public int countReaders(Map<String, Object> map) {
        return sst.selectList("readers.countReaders",map).size();
    }

    public ReaderInfo queryReader(Long readerId) {
        return sst.selectOne("readers.queryReader",readerId);
    }

    public void editReader(ReaderInfo reader) {
        sst.update("readers.editReader",reader);
    }

    public void deleteReader(long readerId) {
        sst.delete("readers.deleteReader",readerId);
    }

    public void addReaderInfo(ReaderInfo reader) {
        sst.insert("readers.addReaderInfo",reader);
    }

    public void addReaderCard(ReaderCard rCard) {
        sst.insert("readers.addReaderCard",rCard);
    }

    public void deleteReaderCard(long readerId) {
        sst.delete("readers.deleteReaderCard",readerId); 
    }

}
