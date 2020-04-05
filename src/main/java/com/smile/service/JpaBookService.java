package com.smile.service;

import com.smile.bean.JpaBook;
import com.smile.dao.JpaBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaBookService {

    @Autowired
    JpaBookDao bookDao;

    public void addBook(JpaBook book) {
        bookDao.save(book);
    }

    public Page<JpaBook> getBookByPage(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    public List<JpaBook> getBooksByAuthorStartingWith(String author) {
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<JpaBook> getBooksByPriceGreaterThan(Float price) {
        return bookDao.getBooksByPriceGreaterThan(price);
    }

    public JpaBook getMaxIdBook() {
        return bookDao.getMaxIdBook();
    }

    public List<JpaBook> getBookByIdAndAuthor(String author, Integer id) {
        return bookDao.getBookByIdAndAuthor(author, id);
    }

    public List<JpaBook> getBooksByIdAndName(String name, Integer id) {
        return bookDao.getBooksByIdAndName(name, id);
    }

}
