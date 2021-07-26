package com.api.book.bootrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id;
    private String name;
    private String address;
    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book; 
    public Author(int author_id, String name, String address, Book book) {
        this.author_id = author_id;
        this.name = name;
        this.address = address;
        this.book =  book;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Author() {
    }
    

}
