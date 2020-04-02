package com.ycz.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName LoginInterceptor
 * @Description TODO(������Ϊ��¼������ʹ��)
 * @author Administrator
 * @Date 2020��4��2�� ����10:22:49
 * @version 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    //�ڿ�����ִ��֮ǰ���ҵ���߼����� �����ķ���ֵ�����߼��Ƿ�������У�true��ʾ������false��ʾ�ж�
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //�ж��û��Ƿ��¼
        HttpSession session = request.getSession();//��ȡ��ǰsession����
        Object user = session.getAttribute("currentUser");//��session���л�ȡ����
        if(user==null) {//���Ϊ��
            String path = session.getServletContext().getContextPath();//��ȡ������·��
            response.sendRedirect(path +"/login/login");//�ض��򵽵�¼����
            return false;
        }else {//��Ϊ�������ִ��
            return true;
        }
    }

    //�ڿ�����ִ�����֮��ִ�е��߼�����
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    //�����ͼ��Ⱦ֮��ִ�еķ���
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
