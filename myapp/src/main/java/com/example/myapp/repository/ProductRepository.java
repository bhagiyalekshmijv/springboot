package com.example.myapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.myapp.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel,Integer> {

}