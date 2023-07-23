package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Course;
import com.spring.boot.data.jpa.entity.Student;
import com.spring.boot.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder().firstName("nishantha").lastName("gamage").build();

        Course course = Course.builder().title("Python").credit(6).teacher(teacher).build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        Integer totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("total Elements = " + totalElements);
        System.out.println("total Pages = " + totalPages);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(1, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder().firstName("Lizze").lastName("Morgan").build();
        Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();

        Student student = Student.builder().firstName("Abisheka").lastName("Wikramasigha").emailId("abisheka@gmail.com").build();
        course.addStudents(student);

        courseRepository.save(course);
    }
}