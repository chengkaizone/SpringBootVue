package com.smile.controller;

import com.smile.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MongoTemplateBookController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("mongotemptest")
    public void test() {
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(3);
        b1.setName("围城");
        b1.setAuthor("钱钟书");
        books.add(b1);

        Book b2 = new Book();
        b2.setId(4);
        b2.setName("宋诗选注");
        b2.setAuthor("钱钟书");
        books.add(b2);

        mongoTemplate.insertAll(books);
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        System.out.println("bookList>>> " + bookList);
        Book book = mongoTemplate.findById(3, Book.class);
        System.out.println("book>>> " + book);
    }

}
