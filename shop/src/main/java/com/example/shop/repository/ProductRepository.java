package com.example.shop.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.shop.models.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}