package com.ycz.service;

import java.util.List;
import java.util.Map;

import com.ycz.pojo.Lend;

public interface LendService {

    List<Lend> queryLendPaged(Map<String, Object> map);

    int countLends(Map<String, Object> map);

    void deleteLend(long serNum);

    List<Long> queryAllBookId(long readerId);

    List<Lend> queryAllLends(long readerId);

    Lend queryLendSure(Map<String, Object> map);

    void updateBackDate(Lend lend);

    void addLend(Lend lend);

    List<Lend> queryLends(long readerId);

}
