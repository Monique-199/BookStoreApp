package com.kerubo.BookStoreApp.controller;

import com.kerubo.BookStoreApp.entity.Book;
import com.kerubo.BookStoreApp.entity.MyBookList;
import com.kerubo.BookStoreApp.service.BookService;
import com.kerubo.BookStoreApp.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;

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
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("books",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
    Book b = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(b.getId(), b.getName(), b.getAuthor(),b.getPrice());
    myBookListService.saveMyBooks(myBookList);
    return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book =bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable ("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";

    }
}
