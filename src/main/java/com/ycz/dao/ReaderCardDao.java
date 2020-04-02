package com.ycz.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;

@Repository
public class ReaderCardDao {
    
    @Autowired
    private SqlSessionTemplate sst;

    public int getMatchCount(long readerId, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        //键名要和pojo属性名一致
        map.put("readerId", readerId);
        map.put("password",password);
        int res = sst.selectOne("readerCard.getMatchCount",map);
        return res;
    }

    public String getReaderPassword(long readerId) {
        return sst.selectOne("readerCard.getPassword",readerId);
    }

    public ReaderCard findReaderById(long readerId) {
        return sst.selectOne("readerCard.findReaderById",readerId);
    }

    public int reReaderPass(long readerId, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("readerId", readerId);
        map.put("password",password);
        return sst.update("readerCard.resetPassword",map);
    }

    public int addReaderCard(ReaderInfo rInfo, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("readerId", rInfo.getReaderId());
        map.put("username",rInfo.getName());
        map.put("password",password);
        return sst.insert("readerCard.addReaderCard",map);
    }

    public int deleteReaderCard(long readerId) {
        return sst.delete("readerCard.deleteReaderCard",readerId);
    }

    public void editReaderCard(Map<String, Object> map) {
        sst.update("readerCard.editReaderCard",map);
    }

}
