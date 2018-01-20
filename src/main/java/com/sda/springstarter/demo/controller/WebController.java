package com.sda.springstarter.demo.controller;

import com.sda.springstarter.demo.service.AuthorServiceImpl;
import com.sda.springstarter.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private AuthorServiceImpl authorService;

    @GetMapping(value = "booklist")
    public ModelAndView showBooks() {
        ModelAndView model = new ModelAndView();
        model.addObject("books", bookService.getAllBooks());
        model.setViewName("booklist");
        return model;
    }

    @GetMapping(value = "authorlist")
    public ModelAndView showAuthors() {
        ModelAndView model = new ModelAndView();
        model.addObject("authors", authorService.getAllAuthors());
        model.setViewName("authorlist");
        return model;
    }
}
