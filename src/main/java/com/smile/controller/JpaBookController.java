package com.smile.controller;

import com.smile.bean.JpaBook;
import com.smile.service.JpaBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaBookController {

    @Autowired
    JpaBookService bookService;

    @GetMapping("/jpafindAll")
    public void findAll() {
        PageRequest request = PageRequest.of(0, 3);
        Page<JpaBook> page = bookService.getBookByPage(request);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("查询结果：" + page.getContent());
        System.out.println("当前页数：" + (page.getNumber() + 1));
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        System.out.println("每页记录数：" + page.getSize());
    }

    @GetMapping("/jpasearch")
    public void search() {
        List<JpaBook> bs1 = bookService.getBookByIdAndAuthor("鲁迅", 1);
        List<JpaBook> bs2 = bookService.getBooksByAuthorStartingWith("吴");
        List<JpaBook> bs3 = bookService.getBooksByIdAndName("西", 3);
        List<JpaBook> bs4 = bookService.getBooksByPriceGreaterThan(30F);

        JpaBook b = bookService.getMaxIdBook();
        System.out.println("bs1:" + bs1);
        System.out.println("bs2:" + bs2);
        System.out.println("bs3:" + bs3);
        System.out.println("bs4:" + bs4);
        System.out.println("b:" + b);
    }

    @GetMapping("/jpasave")
    public void save() {
        JpaBook book = new JpaBook();
        book.setAuthor("鲁迅");
        book.setName("呐喊");
        book.setPrice(23F);
        bookService.addBook(book);
    }
}
