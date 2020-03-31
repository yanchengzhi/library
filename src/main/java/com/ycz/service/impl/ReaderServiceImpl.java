package com.ycz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycz.dao.ReaderDao;
import com.ycz.pojo.Book;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;
import com.ycz.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService {
    
    @Autowired
    private ReaderDao rDao;

    @Override
    public List<ReaderInfo> queryReadersPaged(Map<String, Object> map) {
        return rDao.queryReadersPaged(map);
    }

    @Override
    public int countReaders(Map<String, Object> map) {
        return rDao.countReaders(map);
    }

    @Override
    public ReaderInfo queryReader(Long readerId) {
        return rDao.queryReader(readerId);
    }

    @Override
    public void editReader(ReaderInfo reader) {
        rDao.editReader(reader);
    }

    @Override
    public void deleteReader(long readerId) {
        rDao.deleteReader(readerId);
    }

    @Override
    public void addReaderInfo(ReaderInfo reader) {
        rDao.addReaderInfo(reader);
    }

    @Override
    public void addReaderCard(ReaderCard rCard) {
        rDao.addReaderCard(rCard);  
    }

    @Override
    public void deleteReaderCard(long readerId) {
        rDao.deleteReaderCard(readerId);
    }

    @Override
    public int countBooksReader(Map<String, Object> map) {
        return rDao.countBooksReader(map);
    }

    @Override
    public List<Book> queryBooksReader(Map<String, Object> map) {
        return rDao.queryBooksReader(map);
    }

}
