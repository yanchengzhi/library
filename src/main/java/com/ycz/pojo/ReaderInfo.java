package com.ycz.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName ReaderInfo
 * @Description TODO(读者具体信息类)
 * @author Administrator
 * @Date 2020年3月28日 下午5:02:09
 * @version 1.0.0
 */
public class ReaderInfo implements Serializable {

    /**
     * @Field @serialVersionUID : TODO(这里用一句话描述这个类的作用)
     */
    private static final long serialVersionUID = 1L;
    
    private long readerId;//读者ID
    private String name;//读者姓名
    private String sex;//读者性别
    private Date birth;//读者出生日期
    private String address;//籍贯
    private String phone;//电话号码
    
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
