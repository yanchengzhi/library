package com.ycz.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName ReaderInfo
 * @Description TODO(���߾�����Ϣ��)
 * @author Administrator
 * @Date 2020��3��28�� ����5:02:09
 * @version 1.0.0
 */
public class ReaderInfo implements Serializable {

    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;
    
    private long readerId;//����ID
    private String name;//��������
    private String sex;//�����Ա�
    private Date birth;//���߳�������
    private String birthStr;
    private String address;//����
    private String phone;//�绰����
    private String addTime;//����ֶ�ֻ��������
    private List<Book> books;   
    
    public List<Book> getBooks() {
        return books;
    }
  
    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public String getAddTime() {
        return addTime;
    }

    
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getBirthStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birth);
    }
  
    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
    }
    
    public long getReaderId() {
        return readerId;
    }
    
    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public Date getBirth() {
        return birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

}
