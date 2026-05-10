package com.example.inventorysystem.controller;

import com.example.inventorysystem.exception.BookNotFoundException;
import com.example.inventorysystem.models.BookModel;
import com.example.inventorysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:3002")
public class BookAPIController {


    @Autowired
    private BookRepository bookRepository;


    @PostMapping("api/addproduct")
    BookModel newBook(@RequestBody BookModel newBook) {
        return bookRepository.save(newBook);
    }


    @GetMapping("api/listproduct")
    List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("api/product/{id}")
    BookModel getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }


    @PutMapping("api/updateproduct/{id}")
    BookModel updateBook(@RequestBody BookModel newBook, @PathVariable Integer id) {
        return bookRepository.findById(id)
                .map(book -> {
                	book.setTitle(newBook.getTitle());
                	book.setAuthor(newBook.getAuthor());
                	book.setGenre(newBook.getGenre());
                	book.setPrice(newBook.getPrice());
                	book.setPublisheddate(newBook.getPublisheddate());
                    return bookRepository.save(book);
                }).orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("api/deleteproduct/{id}")
    String deleteBook(@PathVariable Integer id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
        return  "Book with id "+id+" has been deleted success.";
    }
    
     @GetMapping("api/search")
        List<BookModel> searchBooks(@Param("keyword") String keyword) {
            return bookRepository.findAllByKeyword(keyword);
        }
}