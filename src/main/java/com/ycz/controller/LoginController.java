package com.ycz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycz.pojo.Admin;
import com.ycz.pojo.AjaxResult;
import com.ycz.pojo.ReaderCard;
import com.ycz.service.LoginService;

/**
 * 
 * @ClassName LoginController
 * @Description TODO(登录控制器)
 * @author Administrator
 * @Date 2020年3月27日 下午9:32:55
 * @version 1.0.0
 */
@Controller
@RequestMapping("/login/")
public class LoginController {
    
    @Autowired
    private LoginService service;
    
    /**
     * 
     * @Description (跳往管理员主页)
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "admin_main";
    }
    
    /**
     * 
     * @Description (跳往登录页面)
     * @return
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }
    
    /**
     * 
     * @Description (用户登出)
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();//使session失效
        return "redirect:login";//并且重定向到登录页面
    }
    
    /**
     * @Description (跳往读者主页)
     * @return
     */
    @RequestMapping("readermain")
    public String readermain() {
        return "reader_main";
    }
    
    /**
     * 
     * @Description (登录验证)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("loginCheck")
    public Object loginCheck(HttpServletRequest request) {
        //从前端获取参数
        long id = Long.parseLong(request.getParameter("id"));
        String password = request.getParameter("password");
        boolean isAdmin = service.hasMatchAdmin(id, password);
        boolean isReader = service.hasMatchReader(id, password);
        Map<String,Object> res = new HashMap<String ,Object>();
        if(isAdmin) {
            Admin admin = new Admin();
            admin.setId(id);
            admin.setPassword(password);
            admin.setUsername(service.getAdminUsername(id));
            //存到session域中
            request.getSession().setAttribute("currentUser", admin);
            res.put("stateCode", "1");
        }else if(isReader){
            ReaderCard reader = service.findReaderById(id);
            request.getSession().setAttribute("currentUser", reader);
            res.put("stateCode","2");
        }else {
            res.put("stateCode","0");
        }
        return res;
    }
    
    /**
     * 
     * @Description (跳往管理员书籍管理页面)
     * @return
     */
    @RequestMapping("adminBook")
    public String adminBook() {
        return "admin_book";
    }
    
    /**
     * 
     * @Description (跳往密码修改页面)
     * @return
     */
    @RequestMapping("repass")
    public String repass(long id) {
        return "admin_repass";
    }
    
    @ResponseBody
    @RequestMapping("repassDo")
    public AjaxResult repassDo(long id,String password) {
        AjaxResult result = new AjaxResult();
        try {
            service.reAdminPass(id, password);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}
