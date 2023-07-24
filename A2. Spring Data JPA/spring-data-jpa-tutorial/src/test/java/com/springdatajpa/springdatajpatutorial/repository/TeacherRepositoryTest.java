package com.springdatajpa.springdatajpatutorial.repository;

import com.springdatajpa.springdatajpatutorial.entity.Course;
import com.springdatajpa.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBMS = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("JAVA")
                .credit(7)
                .build();
        Course coursePython = Course.builder()
                .title("Python")
                .credit(8)
                .build();

//        Teacher teacher =
//                Teacher.builder()
//                        .firstName("Kaustubh")
//                        .lastName("R")
//                        .course(List.of(courseDBMS,courseJava,coursePython))
//                        .build();
//        teacherRepository.save(teacher);
    }


}