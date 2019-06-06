package com.clemtrib.website.repositories;

import org.springframework.data.repository.CrudRepository;

import com.clemtrib.website.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
