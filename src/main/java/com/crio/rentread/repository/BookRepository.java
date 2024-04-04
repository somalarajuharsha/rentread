package com.crio.rentread.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.rentread.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

    public Book findByTitle(String title);
    
}
