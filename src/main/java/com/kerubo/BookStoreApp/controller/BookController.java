package com.kerubo.BookStoreApp.controller;

import com.kerubo.BookStoreApp.entity.Book;
import com.kerubo.BookStoreApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book-register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        // Fetch all books and add to model for display in the view
        List<Book> list = bookService.getAllBook();
        //ModelAndView m = new ModelAndView();
        //m.setViewName("bookList");
       // m.addObject("book", list);
        return  new ModelAndView("bookList","books",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);  // Save the book to the database
        return "redirect:/available_books";  // Redirect to show the list of books
    }
    @GetMapping("/my_books")
    public String getMyBooks(){
        return "myBooks";
    }
}
