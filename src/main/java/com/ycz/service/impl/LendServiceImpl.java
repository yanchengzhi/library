package com.ycz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycz.dao.LendDao;
import com.ycz.pojo.Lend;
import com.ycz.service.LendService;

@Service
public class LendServiceImpl implements LendService {
    
    @Autowired
    private LendDao lDao;

    @Override
    public List<Lend> queryLendPaged(Map<String, Object> map) {
        return lDao.queryLendPaged(map);
    }

    @Override
    public int countLends(Map<String, Object> map) {
        return lDao.countLends(map);
    }

    @Override
    public void deleteLend(long serNum) {
        lDao.deleteLend(serNum);
    }

    @Override
    public List<Long> queryAllBookId(long readerId) {
        return lDao.queryAllBookId(readerId);
    }

    @Override
    public List<Lend> queryAllLends(long readerId) {
        return lDao.queryAllLends(readerId);
    }

    @Override
    public Lend queryLendSure(Map<String, Object> map) {
        return lDao.queryLendSure(map);
    }

    @Override
    public void updateBackDate(Lend lend) {
        lDao.updateBackDate(lend);
    }

    @Override
    public void addLend(Lend lend) {
        lDao.addLend(lend);
    }

    @Override
    public List<Lend> queryLends(long readerId) {
        return lDao.queryLends(readerId);
    }


}
