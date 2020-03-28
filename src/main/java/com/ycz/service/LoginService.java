package com.ycz.service;

import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;

public interface LoginService {

    public boolean hasMatchAdmin(long id,String password);
    
    public String getAdminUsername(long id);
    
    public String getAdminPassword(long id);
    
    public boolean reAdminPass(long id,String password);
    
    public boolean hasMatchReader(long readerId,String password);
    
    public String getReaderPassword(long readerId);
    
    public ReaderCard findReaderById(long readerId);
    
    public int reReaderPass(long readerId,String password);
    
    public int addReaderCard(ReaderInfo rInfo,String password);
    
    public int deleteReaderCard(long readerId);

}
