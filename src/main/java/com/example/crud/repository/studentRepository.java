package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Student;

public interface studentRepository extends JpaRepository<Student,Integer>{

}
