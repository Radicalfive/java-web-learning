package com.radical.web.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : radical
 * @description : 用户实体类
 * @data : 2022/2/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private  String password;
}
