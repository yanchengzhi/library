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
    
    //查询
    public int getMatchCount(long id,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("password", password);
        int res = sst.selectOne("admin.getMatchCount",map);
        return res;
    }
    
    //获取管理员用户名
    public String getAdminUsername(long id) {
        return sst.selectOne("admin.getUsername",id);
    }
    
    //获取管理员账号密码
    public String getAdminPassword(long id) {
        return sst.selectOne("admin.getPassword",id);
    }
    
    //重置密码
    public int resetPassword(long id,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id", id);
        map.put("password", password);
        int res = sst.update("admin.resetPassword",map);
        return res;
    }

}
