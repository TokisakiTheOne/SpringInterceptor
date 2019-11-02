package com.yyh.interceptor;

import com.yyh.po.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author YanYuHang
 * @create 2019-11-02-19:19
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 这个方法会在控制器方法执行前执行，其返回值表示是否中断操作,
     * 当返回值为true时  表示可以继续向下执行，
     * 当返回值为false时 会中断后续的所有操作(包括调用下一个拦截器和控制器中的方法)
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //1.获取请求的url
        String url = request.getRequestURI();
        //URL  除了  login.jsp 是可以公开显示的，其他的都要拦截
        if(url.indexOf("/login")>=0){
            return true;
        }
        //2.获取session中的值
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("USERS_SESSION");
        if(users!=null){
            return true;
        }
        //不符合条件的
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    /**
     * 这个方法会在会在控制器方法调用之后执行，在视图解析之前执行， 可以对请求域中的数据或者页面
     * 进行进一步的 修改
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 这个方法会在整个请求完成执行执行，可以通过方法对一些数据，日志进行清理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
