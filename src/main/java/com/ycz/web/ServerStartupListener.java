package com.ycz.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @ClassName ServerStartupListener
 * @Description TODO(前端访问路径监听)
 * @author Administrator
 * @Date 2020年3月27日 下午7:55:30
 * @version 1.0.0
 */
public class ServerStartupListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context = arg0.getServletContext();//获取context上下文对象
        String path = context.getContextPath();//获取上下文路径
        context.setAttribute("APP_PATH", path);//存在上下文中
    }

}
