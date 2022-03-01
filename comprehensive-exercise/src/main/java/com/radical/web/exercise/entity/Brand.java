package com.radical.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : radical
 * @description :品牌实体类
 * @data : 2022/2/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 排序字段
     */
    private Integer ordered;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;
}
