package com.ycz.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @ClassName ServerStartupListener
 * @Description TODO(ǰ�˷���·������)
 * @author Administrator
 * @Date 2020��3��27�� ����7:55:30
 * @version 1.0.0
 */
public class ServerStartupListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context = arg0.getServletContext();//��ȡcontext�����Ķ���
        String path = context.getContextPath();//��ȡ������·��
        context.setAttribute("APP_PATH", path);//������������
    }

}
