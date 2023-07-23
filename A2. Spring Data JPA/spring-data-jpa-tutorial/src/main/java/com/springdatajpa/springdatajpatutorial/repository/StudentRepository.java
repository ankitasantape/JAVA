package com.springdatajpa.springdatajpatutorial.repository;

import com.springdatajpa.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

       public List<Student> findByFirstName(String firstName);

       public List<Student> findByFirstNameContaining(String name);

       public List<Student> findByLastNameNotNull();

       public List<Student> findByGuardianName(String guardianName);

       public Student findByFirstNameAndLastName(String firstName, String lastName);

       // JPQL
       @Query("Select s from Student s where s.emailId = ?1")
       public Student getStudentByEmailAddress(String emailId);

       @Query("Select s.firstName from Student s where s.emailId = ?1")
       public String getStudentFirstNameByEmailAddress(String emailId);

       // Native
       @Query(
               value = "select * from tbl_student s where s.email_address = ?1" ,
               nativeQuery = true
       )
       public Student getStudentByEmailAddressNative(String emailId);


       // Query Native Named Param
       @Query(
               value = "select * from tbl_student s where s.email_address = :emailId" ,
               nativeQuery = true
       )
       public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

       @Modifying
       @Transactional
       @Query(
               value = "update tbl_student s set first_name = ?1 where s.email_address = ?2",
               nativeQuery = true
       )
       int updateStudentNameByEmailId(String firstName, String emailId);

       @Modifying
       @Transactional
       @Query(
               value = "update tbl_student s set guardian_name = ?1, guardian_email = ?2, guardian_mobile = ?3 where s.email_address = ?4",
               nativeQuery = true
       )
       int updateGuardianByEmailId(String name, String email, String mobile, String emailId);


}
