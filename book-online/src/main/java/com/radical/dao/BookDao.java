package com.radical.dao;

import com.radical.entity.Book;
import com.radical.util.JdbcUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author : radical
 * @description :操作数据库中book表的类
 * @data : 2022/2/28
 **/
public class BookDao {
    /**
     * 声明JDBCTemplate对象
     */
    private final JdbcTemplate template = new JdbcTemplate(JdbcUtil.getDataSource());

    /**
     * 获取所有图书
     *
     * @return List<Book>
     */
    public List<Book> selectAll() {
        try {
            String sql = "SELECT * FROM t_book ORDER BY id DESC ";
            return template.query(sql, new BeanPropertyRowMapper<>(Book.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookById(int id) {
        try {
            String sql = "SELECT * FROM t_book WHERE id = ? ";
            return template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Book.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
