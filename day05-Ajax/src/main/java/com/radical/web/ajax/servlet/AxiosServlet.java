package com.radical.web.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : radical
 * @description :axios
 * @data : 2022/3/2
 **/
@WebServlet(urlPatterns = "axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        // 1.接收请求参数
        String username = req.getParameter("username");
        System.out.println(username);
        // 2. 响应数据
        resp.getWriter().write("hello axios");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        this.doGet(req, resp);
    }
}
