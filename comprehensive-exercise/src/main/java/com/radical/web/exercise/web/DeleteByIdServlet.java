package com.radical.web.exercise.web;

import com.radical.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author : radical
 * @description :删除方法
 * @data : 2022/3/1
 **/
@Slf4j
@WebServlet("/deleteById")
public class DeleteByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收id
        String id = req.getParameter("id");
        log.info("id=" + id);
        //2.调用service删除
        brandService.deleteById(Integer.parseInt(id));
        //3.重定向到查询所有Servlet
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/index");
    }
}
