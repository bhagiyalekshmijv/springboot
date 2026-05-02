package com.example.book_store.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.book_store.models.BookModel;

public interface BookRepository extends CrudRepository<BookModel,Integer> {

}