package com.radical.web.brand.pojo;

import java.util.List;

/**
 * @author : radical
 * @description :分页查询的JavaBean
 * @data : 2022/3/4
 **/
public class PageBean<T> {
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 当前页数据
     */
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
