package com.ycz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycz.dao.AdminDao;
import com.ycz.dao.ReaderCardDao;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;
import com.ycz.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private AdminDao aDao;
    
    @Autowired
    private ReaderCardDao rDao;

    @Override
    public boolean hasMatchAdmin(long id, String password) {
        return aDao.getMatchCount(id, password)>0;
    }

    @Override
    public String getAdminUsername(long id) {
        return aDao.getAdminUsername(id);
    }

    @Override
    public String getAdminPassword(long id) {
        return aDao.getAdminPassword(id);
    }

    @Override
    public boolean reAdminPass(long id, String password) {
        return aDao.resetPassword(id, password)>0;
    }

    @Override
    public boolean hasMatchReader(long readerId, String password) {
        return rDao.getMatchCount(readerId,password)>0;
    }

    @Override
    public String getReaderPassword(long readerId) {
        return rDao.getReaderPassword(readerId);
    }

    @Override
    public ReaderCard findReaderById(long readerId) {
        return rDao.findReaderById(readerId);
    }

    @Override
    public int reReaderPass(long readerId, String password) {
        return rDao.reReaderPass(readerId,password);
    }

    @Override
    public int addReaderCard(ReaderInfo rInfo, String password) {
        return rDao.addReaderCard(rInfo,password);
    }

    @Override
    public int deleteReaderCard(long readerId) {
        return rDao.deleteReaderCard(readerId);
    }


}
