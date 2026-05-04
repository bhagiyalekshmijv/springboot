package com.example.mobileshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.mobileshop.models.PhoneModel;

public interface PhoneRepository extends CrudRepository<PhoneModel,Integer> {

    @Query("SELECT p.name, p.price FROM PhoneModel p")
    List<Object[]> findNamesAndPrices();
    
    @Query("SELECT p.name, p.price FROM PhoneModel p WHERE p.price < 20000")
    List<Object[]> findCheapPhones();

    @Query("SELECT p.type, COUNT(p) FROM PhoneModel p GROUP BY p.type")
    List<Object[]> countPhonesByType();
}