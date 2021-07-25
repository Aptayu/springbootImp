package com.api.book.bootrestbook.controller;

import java.util.Optional;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class BookController {

    @Autowired
    Book book;
    @Autowired
    BookService bookService;
    
    @GetMapping("/books")
    public ResponseEntity<Book> getBooks(){
        
        
        book.setId(1);
        book.setName("java");
        book.setPrice("100");
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));

    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book book){

        this.bookService.addBook(book);

    }

    @DeleteMapping("/books/{id}")   
    public void deleteBook(@PathVariable("id") int id){
            this.bookService.deleteBook(id);
    }
    // update book getting the new Book object
    // id book which needs to be updated

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id){
        this.bookService.updateBook(book,id);
        return book;
    }

    
}
