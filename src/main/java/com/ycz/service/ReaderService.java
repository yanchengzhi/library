package com.ycz.service;

import java.util.List;
import java.util.Map;

import com.ycz.pojo.Book;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;

public interface ReaderService {

    List<ReaderInfo> queryReadersPaged(Map<String, Object> map);

    int countReaders(Map<String, Object> map);

    ReaderInfo queryReader(Long readerId);

    void editReader(ReaderInfo reader);

    void deleteReader(long readerId);

    void addReaderInfo(ReaderInfo reader);

    void addReaderCard(ReaderCard rCard);

    void deleteReaderCard(long readerId);

    int countBooksReader(Map<String, Object> map);

    List<Book> queryBooksReader(Map<String, Object> map);

}
