package com.ycz.pojo;

/**
 * 
 * @ClassName Admin
 * @Description TODO(管理员类)
 * @author Administrator
 * @Date 2020年3月27日 下午9:21:33
 * @version 1.0.0
 */
public class Admin {
    
    private Long id;//ID主键
    private String username;//用户名
    private String password;//密码
    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
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
