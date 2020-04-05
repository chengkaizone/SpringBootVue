package com.smile.mapper;

import com.smile.bean.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBook(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();

}
