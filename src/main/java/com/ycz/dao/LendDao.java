package com.ycz.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ycz.pojo.Lend;

@Repository
public class LendDao {
    
    @Autowired
    private SqlSessionTemplate sst;

    public List<Lend> queryLendPaged(Map<String, Object> map) {
        return sst.selectList("lends.queryLendPaged",map);
    }

    public int countLends(Map<String, Object> map) {
        return sst.selectList("lends.countLends",map).size();
    }

    public void deleteLend(long serNum) {
        sst.delete("lends.deleteLend",serNum);
    }

    public List<Long> queryAllBookId(long readerId) {
        return sst.selectList("lends.queryAllBookId",readerId);
    }

    public List<Lend> queryAllLends(long readerId) {
        return sst.selectList("lends.queryAllLends",readerId);
    }

}
