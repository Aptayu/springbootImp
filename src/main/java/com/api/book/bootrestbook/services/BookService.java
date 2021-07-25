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

    public boolean addBook(Book b){
        return list.add(b);
    }

    public void deleteBook(int id) {
        //Now our list will have all the Book which do not have id given 
       list =  list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book, int id) {
        list = list.stream().map(b->{
            if(b.getId() == id){
                b.setName(book.getName());
                b.setPrice(book.getPrice());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
