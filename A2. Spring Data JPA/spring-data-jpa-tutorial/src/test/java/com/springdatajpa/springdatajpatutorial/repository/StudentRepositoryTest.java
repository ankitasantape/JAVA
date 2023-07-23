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
                .email("K.K@gmail.com")
                .mobile("2222222222")
                .build();

        Student student = Student.builder()
                .firstName("Sham")
                .lastName("Sundar")
                .emailId("Sham@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Shakti");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull(){

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> guardian = studentRepository.findByGuardianName("K");
        System.out.println("Guardian name = " + guardian);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("ankitasantape@gmail.com");
        System.out.println("Student By EmailAddress = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String name = studentRepository.getStudentFirstNameByEmailAddress("ankitasantape@gmail.com");
        System.out.println("First Name = " + name);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("ankitasantape@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("ankitasantape@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int student = studentRepository.updateStudentNameByEmailId("Anamika","ankitasantape@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateGuardianByEmailIdTest(){
        int student = studentRepository.updateGuardianByEmailId("Maya","maya@gmail.com","4444444444","shiva" +
                "@gmail.com");
        System.out.println(student);
    }
}
