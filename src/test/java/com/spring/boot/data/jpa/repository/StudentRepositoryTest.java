package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Guardian;
import com.spring.boot.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().firstName("Lakindu")
                                    .lastName("De Zoysa").emailId("lakinduvirajith@gmail.comm")
                                    .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder().name("Shanthalal")
                .mobile("0774780776").email("shanthalal@gmail.com")
                .build();

        Student student = Student.builder().firstName("Lakindu")
                .lastName("De Zoysa").emailId("lakinduvirajith@gmail.com")
                .guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Lakindu");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Laki");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Shanthalal");

        System.out.println("Students : " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Lakindu", "De Zoysa");

        System.out.println("Student : " + student);
    }

    @Test
    public void printLastStudentId(){
        String id = studentRepository.findLastStudentId();

        System.out.println("Student ID : " + id);
    }

    @Test
    public void printLastStudentIdNativeQuery(){
        String id = studentRepository.findLastStudentIdNativeQuery();

        System.out.println("Student ID : " + id);
    }

    @Test
    public void printEmailIdNativeQuery(){
        String email = studentRepository.findEmailIdNativeQuery("Lakindu");

        System.out.println("Student Email : " + email);
    }

    @Test
    public void printEmailIdIdNativeNamedParam(){
        String email = studentRepository.findEmailIdIdNativeNamedParam("Lakindu");

        System.out.println("Student Email : " + email);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("lakindu", "lakinduvirajith@gmail.com");
    }
}