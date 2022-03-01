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

/**
 * @author : radical
 * @description :新增品牌逻辑处理
 * @data : 2022/2/28
 **/
@Slf4j
@WebServlet(urlPatterns = "/addBrand")
public class AddBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受表单提交的数据，封装为一个Brand对象
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        //封装为一个Brand对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        // 2.调用service 完成添加
        brandService.add(brand);

        // 3.重定向到查询所有Servlet
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/index");
    }
}
