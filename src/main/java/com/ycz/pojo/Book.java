package com.ycz.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName Book
 * @Description TODO(�鼮ʵ���࣬���л�)
 * @author Administrator
 * @Date 2020��3��28�� ����4:43:01
 * @version 1.0.0
 */
public class Book implements Serializable {
    
    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;
    
    private long bookId;//�鼮ID����
    private String name;//�鼮����
    private String author;//�鼮����
    private String publish;//������
    private String ISBN;//���ʱ�׼���
    private String introduction;//���
    private String language;//����
    private BigDecimal price;//�۸�
    private Date pubDate;//����ʱ��
    private int classId;//�鼮������Ŀ
    private int number;//����
    
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
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublish() {
        return publish;
    }
    
    public void setPublish(String publish) {
        this.publish = publish;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    
    public String getIntroduction() {
        return introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Date getPubDate() {
        return pubDate;
    }
    
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    
    public int getClassId() {
        return classId;
    }
    
    public void setClassId(int classId) {
        this.classId = classId;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
}
