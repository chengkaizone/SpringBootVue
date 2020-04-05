package com.smile.dao;

import com.smile.bean.JpaBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBookDao extends JpaRepository<JpaBook, Integer> {

    List<JpaBook> getBooksByAuthorStartingWith(String author);

    List<JpaBook> getBooksByPriceGreaterThan(Float price);

    @Query(value = "select * from t_book where id=(select max(id) from t_book)", nativeQuery = true)
    JpaBook getMaxIdBook();

    @Query("select b from t_book b where b.id>:id and b.author=:author")
    List<JpaBook> getBookByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query("select b from t_book b where b.id<?2 and b.name like %?1%")
    List<JpaBook> getBooksByIdAndName(String name, Integer id);

}
