package com.kerubo.BookStoreApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book-register")
    public String bookRegister(){
        return "bookRegister";
    }
}
