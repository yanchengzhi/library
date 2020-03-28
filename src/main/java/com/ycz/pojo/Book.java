package com.ycz.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @ClassName Book
 * @Description TODO(书籍实体类，序列化)
 * @author Administrator
 * @Date 2020年3月28日 下午4:43:01
 * @version 1.0.0
 */
public class Book implements Serializable {
    
    /**
     * @Field @serialVersionUID : TODO(这里用一句话描述这个类的作用)
     */
    private static final long serialVersionUID = 1L;
    
    private long bookId;//书籍ID主键
    private String name;//书籍名称
    private String author;//书籍作者
    private String publish;//出版社
    private String ISBN;//国际标准书号
    private String introduction;//简介
    private String language;//语言
    private BigDecimal price;//价格
    private Date pubDate;//出版时间
    private int classId;//书籍所属类目
    private int number;//数量
    
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
