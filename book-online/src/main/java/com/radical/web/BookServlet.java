package com.radical.web;

import com.radical.dao.BookDao;
import com.radical.entity.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : radical
 * @description :
 * @data : 2022/2/28
 **/
@WebServlet(urlPatterns = "/book/*")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的URI，并去除空格
        String requestPath = req.getRequestURI().trim();
        //获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");
        String id = requestPath.substring(position + 1);
        //调用BookDao查找
        Book book = new BookDao().getBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }

}
