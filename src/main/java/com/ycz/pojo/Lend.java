package com.ycz.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName Lend
 * @Description TODO(������Ϣ)
 * @author Administrator
 * @Date 2020��3��28�� ����4:53:10
 * @version 1.0.0
 */
public class Lend implements Serializable {

    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;
    
    private long serNum;//ID����
    private long bookId;//�鼮ID
    private long readerId;//����ID
    private Date lendDate;//�������
    private Date backDate;//�黹����
    private String lendDateStr;
    private String backDateStr;
    
    
    public String getLendDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(lendDate);
    }

    
    public void setLendDateStr(String lendDateStr) {
        this.lendDateStr = lendDateStr;
    }

    
    public String getBackDateStr() {
        if(backDate!=null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(backDate);
        }else {
            return "δ�黹";
        }
    }

    
    public void setBackDateStr(String backDateStr) {
        this.backDateStr = backDateStr;
    }

    public long getSerNum() {
        return serNum;
    }
    
    public void setSerNum(long serNum) {
        this.serNum = serNum;
    }
    
    public long getBookId() {
        return bookId;
    }
    
    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
    
    public long getReaderId() {
        return readerId;
    }
    
    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }
    
    public Date getLendDate() {
        return lendDate;
    }
    
    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }
    
    public Date getBackDate() {
        return backDate;
    }
    
    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    

}
