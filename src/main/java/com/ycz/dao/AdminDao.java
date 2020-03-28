package com.ycz.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

    @Autowired
    private SqlSessionTemplate sst;
    
    //��ѯ
    public int getMatchCount(long id,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("password", password);
        int res = sst.selectOne("admin.getMatchCount",map);
        return res;
    }
    
    //��ȡ����Ա�û���
    public String getAdminUsername(long id) {
        return sst.selectOne("admin.getUsername",id);
    }
    
    //��ȡ����Ա�˺�����
    public String getAdminPassword(long id) {
        return sst.selectOne("admin.getPassword",id);
    }
    
    //��������
    public int resetPassword(long id,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("password", password);
        int res = sst.update("admin.resetPassword",map);
        return res;
    }

}
