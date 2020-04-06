package com.smile.dao;

import com.smile.bean.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoDB数据库演示
 */
public interface MongoBookDao extends MongoRepository<Book, Integer> {

    List<Book> findByAuthorContains(String author);
    Book findByNameEquals(String name);

}
