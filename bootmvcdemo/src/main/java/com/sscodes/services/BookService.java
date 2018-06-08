package com.sscodes.services;

import com.sscodes.model.Book;
import com.sscodes.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class will be responsible for handling book service
 *
 * Created by sam on 8/6/18.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }
}
