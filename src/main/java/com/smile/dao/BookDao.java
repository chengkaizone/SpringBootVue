package com.smile.dao;

import com.smile.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JdbcTemplate演示
 */
@Repository
@CacheConfig(cacheNames = "book_cache")
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int addBook(Book book) {
        return jdbcTemplate.update("insert into book(name, author) values(?, ?)", book.getName(), book.getAuthor());
    }

    public int updateBook(Book book) {
        return jdbcTemplate.update("update book set name = ?, author = ? where id = ?", book.getName(), book.getAuthor(), book.getId());
    }

    public int deleteBookById(Integer id) {
        return jdbcTemplate.update("delete from book where id = ?", id);
    }

    public Book getBookById(Integer id) {
        return jdbcTemplate.queryForObject("select * from book where id = ?", new BeanPropertyRowMapper<>(Book.class), id);
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

}
