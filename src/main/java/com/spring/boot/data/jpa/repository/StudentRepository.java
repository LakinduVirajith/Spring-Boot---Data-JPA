package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//  Find Student By Name
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName, String LastName);

//  JPQL
    @Query("SELECT s.studentId FROM Student s ORDER BY s.studentId DESC")
    String findLastStudentId();

//  NativeQuery
    @Query(value = "SELECT s.student_id FROM student_table s ORDER BY s.student_id DESC LIMIT 1", nativeQuery = true)
    String findLastStudentIdNativeQuery();

    @Query(value = "SELECT s.email_id FROM student_table s WERE s.first_name = ?1", nativeQuery = true)
    String findEmailIdNativeQuery(String firstName);

//  Native Named Param
    @Query(value = "SELECT s.email_id FROM student_table s WERE s.first_name = :firstName", nativeQuery = true)
    String findEmailIdIdNativeNamedParam(@Param("firstName") String firstName);

//  Update NativeQuery
    @Modifying
    @Transactional
    @Query(value = "UPDATE student_table SET first_name = ?1 WHERE email_id = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);
}
