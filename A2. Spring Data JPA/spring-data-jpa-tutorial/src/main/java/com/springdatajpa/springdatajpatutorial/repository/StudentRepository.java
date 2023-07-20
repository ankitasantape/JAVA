package com.springdatajpa.springdatajpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository<Student> extends JpaRepository<Student, Long> {


}
