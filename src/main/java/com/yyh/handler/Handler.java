package com.yyh.handler;

import com.yyh.po.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author YanYuHang
 * @create 2019-11-02-18:39
 */
@Controller
public class Handler {
    /**
     * 跳转到用户登陆页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }

    /**
     * 用户登录方法
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Users users, Model model, HttpSession session){
        //获取用户名和密码
        String username = users.getUsername();
        String password = users.getPassword();
        if(username!=null && password!=null){
            if("admin".equals(username)&&"123".equals(password)){
                //登录成功  把用户信息放入session作用域中
                session.setAttribute("USERS_SESSION",users);
                //登录成功 跳转到主页面
                return "index";
            }
        }
        model.addAttribute("msg","用户名或者密码错误，请重新登录");
        return "login";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        //清除session
        session.invalidate();
        //向登录页面跳转
        return "login";
    }

}
