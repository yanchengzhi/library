package com.ycz.pojo;

/**
 * 
 * @ClassName ResultData
 * @Description TODO(����������װ��ͬ���л�ȡ����Ϣ)
 * @author Administrator
 * @Date 2020��4��1�� ����11:59:54
 * @version 1.0.0
 */
public class ResultData {
    
    private long bookId;//�鼮ID
    private String name;//����
    private String lendDateStr;//�������
    private String backDateStr;//�黹����
    
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
