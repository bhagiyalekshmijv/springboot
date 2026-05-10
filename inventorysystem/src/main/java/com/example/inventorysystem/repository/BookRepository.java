package com.example.inventorysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.inventorysystem.models.BookModel;
import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
    @Query("SELECT p FROM BookModel p WHERE p.title LIKE %:keyword% OR p.author LIKE %:keyword%")
    List<BookModel> findAllByKeyword(@Param("keyword") String keyword);
}