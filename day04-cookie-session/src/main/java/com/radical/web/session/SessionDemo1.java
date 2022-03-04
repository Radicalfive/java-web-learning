package com.radical.web.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author : radical
 * @description :获取Session对象、存储数据
 * @data : 2022/2/28
 **/
@Slf4j
@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = "radical";
        // 1. 获取Session对象
        HttpSession session = req.getSession();
        // 打印session
        log.info(String.valueOf(session));
        //2. 存储数据
        session.setAttribute("username", info);
        resp.getWriter().write(info);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
