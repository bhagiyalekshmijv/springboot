package com.example.studentrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.studentrecord.models.StudentModel;
import java.util.List;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    @Query("SELECT p FROM StudentModel p WHERE p.name LIKE %:keyword% OR p.studentClass LIKE %:keyword%")
    List<StudentModel> findAllByKeyword(@Param("keyword") String keyword);
}