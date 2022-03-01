package com.radical.web.exercise.web;

import com.radical.web.exercise.entity.Brand;
import com.radical.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * @author : radical
 * @description : 首页、查询所有品牌
 * @data : 2022/2/28
 **/
@Slf4j
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 调用BrandService完成查询
        List<Brand> brands = brandService.selectAll();
        //2.存入request中
        req.setAttribute("brands",brands);
        //3.转发到brand.jsp中
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
