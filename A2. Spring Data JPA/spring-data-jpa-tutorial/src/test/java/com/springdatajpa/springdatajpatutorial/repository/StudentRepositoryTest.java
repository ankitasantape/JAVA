package com.springdatajpa.springdatajpatutorial.repository;


import com.springdatajpa.springdatajpatutorial.entity.Guardian;
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
//                 .guardianName("K")
//                 .guardianEmail("K.K@gmail.com")
//                 .guardianMobile("2222222222")
                 .build();

         studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("K K")
                .email("K.K@email.com")
                .mobile("2222222222")
                .build();

        Student student = Student.builder()
                .firstName("Shakti")
                .lastName("Suman")
                .emailId("Shakti@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);
    }
}