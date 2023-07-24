package com.springdatajpa.springdatajpatutorial.repository;

import com.springdatajpa.springdatajpatutorial.entity.Course;
import com.springdatajpa.springdatajpatutorial.entity.Guardian;
import com.springdatajpa.springdatajpatutorial.entity.Student;
import com.springdatajpa.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priya")
                .lastName("Singh")
                .build();

        Course course =
                Course.builder()
                        .title("C++")
                        .credit(9)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
               PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
               PageRequest.of(1, 2);

        List<Course> courses1 =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println("Courses : " + courses1);

        List<Course> courses2 =
                courseRepository.findAll(secondPageWithTwoRecords).getContent();

        System.out.println("Courses : " + courses2);

        long totalElements1 = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();

        long totalPages1 = courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalPages();

        System.out.println("TotalPages : " + totalPages1);
        System.out.println("TotalElements : " + totalElements1);

        long totalElements2 = courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages2 = courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("TotalPages : " + totalPages2);
        System.out.println("TotalElements : " + totalElements2);

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                Sort.by("title"));

        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);
        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords
                ).getContent();
        System.out.println("Courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Homi")
                .lastName("Bhabha")
                .build();

        Guardian guardian = Guardian.builder()
                .name("C V Raman")
                .email("c.raman@gmail.com")
                .mobile("8888888888")
                .build();

        Student student1 = Student.builder()
                .firstName("Vikram")
                .lastName("Sarabhai")
                .emailId("vikram.sarabhai@gmail.com")
                .guardian(guardian)
                .build();

        Student student2 = Student.builder()
                .firstName("Abdul")
                .lastName("Kalam")
                .emailId("abdul.kalam@gmail.com")
                .guardian(guardian)
                .build();

        Course course =
                Course.builder()
                        .title("AI")
                        .credit(10)
                        .teacher(teacher)
                        .build();
//        course.addStudents(List.of(student1,student2));
        course.addStudents(student1);
//        course.addStudents(student2);
        courseRepository.save(course);
    }

}