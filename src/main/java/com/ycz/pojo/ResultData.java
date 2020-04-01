package com.ycz.pojo;

/**
 * 
 * @ClassName ResultData
 * @Description TODO(此类用来封装不同表中获取的信息)
 * @author Administrator
 * @Date 2020年4月1日 下午11:59:54
 * @version 1.0.0
 */
public class ResultData {
    
    private long bookId;//书籍ID
    private String name;//书名
    private String lendDateStr;//借出日期
    private String backDateStr;//归还日期
    
    public long getBookId() {
        return bookId;
    }
    
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLendDateStr() {
        return lendDateStr;
    }
    
    public void setLendDateStr(String lendDateStr) {
        this.lendDateStr = lendDateStr;
    }
    
    public String getBackDateStr() {
        return backDateStr;
    }
    
    public void setBackDateStr(String backDateStr) {
        this.backDateStr = backDateStr;
    }
    
    

}
