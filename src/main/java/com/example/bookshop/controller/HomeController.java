package com.example.bookshop.controller;

import com.example.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final BookService bookService;

    @GetMapping({"/","home"})
    public String home(Model model){
        model.addAttribute("books",bookService.listBooks());
        return "home";
    }
}