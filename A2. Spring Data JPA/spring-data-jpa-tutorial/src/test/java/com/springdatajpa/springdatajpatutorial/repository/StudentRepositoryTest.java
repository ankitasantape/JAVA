package com.springdatajpa.springdatajpatutorial.repository;


import com.springdatajpa.springdatajpatutorial.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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

    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);
    }
}