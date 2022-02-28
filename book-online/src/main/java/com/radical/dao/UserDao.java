package com.radical.dao;

import com.radical.entity.User;
import com.radical.util.JdbcUtil;
import com.radical.utils.Md5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author : radical
 * @description :操作数据库中user表的类
 * @data : 2022/2/28
 **/
public class UserDao {
    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    /**
     * 登录方法
     *
     * @param userDto 只有用户名和密码
     * @return user包含用户全部数据, 没有查询到，返回null
     */
    public User signIn(User userDto) {
        try {
            //1.编写sql
            String sql = "SELECT * FROM t_user WHERE account = ? AND password = ? ";
            //2.调用query方法,比对账号和加密后的密码
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    userDto.getAccount(), Md5Util.crypt(userDto.getPassword()));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 注册方法
     */
    public int regist(User regUser) {
        try {
            //1.编写sql
            String sql = "INSERT INTO  t_user(account,password,nickname,avatar) VALUES (?,?,?,?) ";
            //2.调用query方法
            return template.update(sql, regUser.getAccount(), regUser.getPassword(), regUser.getNickname(), regUser.getAvatar());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

