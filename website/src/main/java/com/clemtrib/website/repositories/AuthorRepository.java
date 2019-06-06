package com.clemtrib.website.repositories;

import org.springframework.data.repository.CrudRepository;

import com.clemtrib.website.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
