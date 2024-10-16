package com.kerubo.BookStoreApp.service;

import com.kerubo.BookStoreApp.entity.Book;
import com.kerubo.BookStoreApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book b){
        bookRepository.save(b);

    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();

    }
}
