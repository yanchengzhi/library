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

}
