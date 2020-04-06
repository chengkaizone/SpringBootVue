package com.smile.repository;

import com.smile.bean.JpaBook;
import com.smile.bean.RestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@NoRepositoryBean
@RepositoryRestResource(path = "restbooks", collectionResourceRel = "restbooks", itemResourceRel = "book")
public interface JpaBookRepository extends JpaRepository<RestBook, Integer> {

}
