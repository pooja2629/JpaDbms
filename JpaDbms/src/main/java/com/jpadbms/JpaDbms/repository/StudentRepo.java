package com.jpadbms.JpaDbms.repository;

import com.jpadbms.JpaDbms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findById(Integer id);

    List<Student> findByName(String name);

    List<Student> findByCity(String city);

    List<Student> findByIdAndName(Integer id, String name);
}