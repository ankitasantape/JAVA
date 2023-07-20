package com.springdatajpa.springdatajpatutorial.repository;


import com.springdatajpa.springdatajpatutorial.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
     private StudentRepository studentRepository;

    @Test
     public void saveStudent() {
         Student student = Student.builder()
                 .emailId("ankitasantape@gmail.com")
                 .firstName("Ankita")
                 .lastName("Sant")
                 .guardianName("K")
                 .guardianEmail("K.K@gmail.com")
                 .guardianMobile("2222222222")
                 .build();

         studentRepository.save(student);

     }
}