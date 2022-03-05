package com.radical.web.brand.service;

import com.radical.web.brand.pojo.Brand;
import com.radical.web.brand.pojo.PageBean;

import java.util.List;

/**
 * @author : radical
 * @description :
 * @data : 2022/3/4
 **/
public interface BrandService {
    /**
     * 查询所有
     *
     * @return List<Brand>
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand 对象
     */
    void add(Brand brand);

    /**
     * 批量删除
     *
     * @param ids ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage  当前页
     * @param pageSize 每页数量
     * @param brand 查询条件对象
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);

}
