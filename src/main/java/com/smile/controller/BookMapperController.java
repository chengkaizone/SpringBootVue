package com.smile.controller;

import com.smile.bean.Book;
import com.smile.service.BookMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookMapperController {

    @Autowired
    BookMapperService bookMapperService;

    @GetMapping("/bookMapperOps")
    public void bookOps() {
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫2");
        int i = bookMapperService.addBook(b1);
        System.out.println("addBook>>>" + i);

        Book b2 = new Book();
        b2.setId(1);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅2");
        int updateBook = bookMapperService.updateBook(b2);
        System.out.println("updateBook>>>" + updateBook);

        Book b3 = bookMapperService.getBookById(1);
        System.out.println("getBookById>>>" + b3);

        int delete = bookMapperService.deleteBookById(2);
        System.out.println("deleteBookById>>>" + delete);

        List<Book> allBooks = bookMapperService.getAllBooks();
        System.out.println("getAllBooks>>>" + allBooks);
    }

}
