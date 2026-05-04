package com.example.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel,Integer> {

    @Query("SELECT p.name, p.price FROM ProductModel p")
    List<Object[]> findNamesAndPrices();
    
}