package com.ycz.pojo;

import java.io.Serializable;

/**
 * @ClassName ReaderCard
 * @Description TODO(读者类，此类用来管理读者登录)
 * @author Administrator
 * @Date 2020年3月27日 下午9:29:32
 * @version 1.0.0
 */
public class ReaderCard implements Serializable {

    /**
     * @Field @serialVersionUID : TODO(这里用一句话描述这个类的作用)
     */
    private static final long serialVersionUID = 1L;

    private Long readerId;// 读者ID
    private String username;// 读者姓名
    private String password;// 密码

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
