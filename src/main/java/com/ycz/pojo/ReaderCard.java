package com.ycz.pojo;

import java.io.Serializable;

/**
 * @ClassName ReaderCard
 * @Description TODO(�����࣬��������������ߵ�¼)
 * @author Administrator
 * @Date 2020��3��27�� ����9:29:32
 * @version 1.0.0
 */
public class ReaderCard implements Serializable {

    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;

    private Long readerId;// ����ID
    private String username;// ��������
    private String password;// ����

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
