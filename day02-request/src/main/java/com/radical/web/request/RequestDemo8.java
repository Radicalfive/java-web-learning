package com.radical.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : radical
 * @description :Request对象：forward转发
 * @data : 2022/2/26
 **/
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8被访问了...");
        //存储数据到request域中
        request.setAttribute("msg", "hello");
        //转发到requestDemo9资源
        request.getRequestDispatcher("/requestDemo9").forward(request, response);
        // 无法跨域转发
        //request.getRequestDispatcher("http://www.baidu.com").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

