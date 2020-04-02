package com.ycz.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName LoginInterceptor
 * @Description TODO(此类作为登录拦截器使用)
 * @author Administrator
 * @Date 2020年4月2日 下午10:22:49
 * @version 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    //在控制器执行之前完成业务逻辑操作 方法的返回值决定逻辑是否继续进行，true表示继续，false表示中断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //判断用户是否登录
        HttpSession session = request.getSession();//获取当前session对象
        Object user = session.getAttribute("currentUser");//从session域中获取对象
        if(user==null) {//如果为空
            String path = session.getServletContext().getContextPath();//获取上下文路径
            response.sendRedirect(path +"/login/login");//重定向到登录界面
            return false;
        }else {//不为空则继续执行
            return true;
        }
    }

    //在控制器执行完毕之后执行的逻辑操作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    //完成视图渲染之后执行的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
