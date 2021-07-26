package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private static List<Book> list = new ArrayList<>();

    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;

    }
    public Book getBookById(int id){
        Book book = null;
        try {
            book = this.bookRepository.findById(id);  
           
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return book;
        
    }
    
    

    public Book addBook(Book b){
        Book book = this.bookRepository.save(b);
        return book;
    }

    public void deleteBook(int id) {
        //Now our list will have all the Book which do not have id given 
        this.bookRepository.delete(this.bookRepository.findById(id));
    
    }

    public void updateBook(Book book, int id) {
        book.setId(id);
        this.bookRepository.save(book);
    }
}
