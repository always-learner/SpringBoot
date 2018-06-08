package com.sscodes.controller;

import com.sscodes.model.Book;
import com.sscodes.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Book
 * This will be responsible for handling incoming traffic for books
 *
 * Created by sam on 8/6/18.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String addBook(Book book){
        return "book";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book, Model model){
        bookService.addNewBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
