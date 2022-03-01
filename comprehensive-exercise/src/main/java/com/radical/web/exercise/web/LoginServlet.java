package com.radical.web.exercise.web;

import com.radical.web.exercise.entity.User;
import com.radical.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * @author : radical
 * @description :登录逻辑处理
 * @data : 2022/2/28
 **/
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户账号密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 1.1.是否选择记住账号密码
        String remember = req.getParameter("remember");
        System.out.println(remember + "=====================");

        //2.调用service进行登录
        User user = userService.login(username, password);

        //3.判断
        if (user != null) {
            //非空（登录成功）
            if ("on".equals(remember)) {
                System.out.println("需要记录Cookie");
                // 1.创建cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassWord = new Cookie("password", password);
                // 2.设置存活时间（7天）
                cUserName.setMaxAge(60*60*24*7);
                cPassWord.setMaxAge(60*60*24*7);

                // 3.发送
                resp.addCookie(cUserName);
                resp.addCookie(cPassWord);
            }
            // 将用户信息记载sessions中
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            String contextPath = req.getContextPath();
            System.out.println(contextPath);
            resp.sendRedirect(contextPath + "/index");

        }else {
            //登录失败
            // 登录失败
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<script>alert('用户名或密码错误');location='/login.html';</script>");
        }
    }
}
