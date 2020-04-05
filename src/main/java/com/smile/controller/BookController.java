package com.smile.controller;

import com.smile.bean.Author;
import com.smile.bean.Book;
import com.smile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/bookAndAuthor")
    public String bookAndAuthor(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        return book.toString() + ">>>" + author.toString();
    }

    @GetMapping("/book")
    public Book book() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        return book;
    }

    @GetMapping("/books")
    public ModelAndView books() {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId(1);
        book.setAuthor("罗贯中");
        book.setName("三国演义");

        Book book2 = new Book();
        book2.setId(2);
        book2.setAuthor("曹雪芹");
        book2.setName("红楼梦");

        books.add(book);
        books.add(book2);

        ModelAndView view = new ModelAndView();
        view.addObject("books", books);
        view.setViewName("books");
        return view;
    }

    @Autowired
    BookService bookService;
    @GetMapping("/bookOps")
    public void bookOps() {
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫");
        int i = bookService.addBook(b1);
        System.out.println("addBook>>>" + i);

        Book b2 = new Book();
        b2.setId(1);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook>>>" + updateBook);

        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>" + b3);

        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById>>>" + delete);

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>" + allBooks);
    }

    //////////////////// 跨域访问 ////////////////////////

    @PostMapping("/")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {

        return "receive:" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }

}
