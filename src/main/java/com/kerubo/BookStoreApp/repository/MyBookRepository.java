package com.kerubo.BookStoreApp.repository;

import com.kerubo.BookStoreApp.entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
