package com.radical.web.exercise.web;

import com.radical.web.exercise.entity.User;
import com.radical.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author : radical
 * @description :
 * @data : 2022/3/1
 **/
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名和密码的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取用户输入的验证码
        String inputCode = req.getParameter("inputCode");

        //程序生成的验证码，从Session获取
        HttpSession session = req.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        resp.setContentType("text/html;charset=utf-8");
        String contextPath = req.getContextPath();

        //忽略大小写对比
        if (!verifyCode.equalsIgnoreCase(inputCode)) {
            //验证码错误，跳回注册页面
            resp.getWriter().write("<script>alert('验证码错误');location='/register.html';</script>");
        }
        // 2.调用service 注册
        boolean flag = userService.register(user);

        //3.判断是否注册成功
        if (flag) {
            //注册成功，跳转到登陆页面
            resp.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");
        } else {
            //用户名已存在，注册失败，跳回注册页面
            resp.getWriter().write("<script>alert('用户名已存在');location='/register.html';</script>");
        }

    }
}
