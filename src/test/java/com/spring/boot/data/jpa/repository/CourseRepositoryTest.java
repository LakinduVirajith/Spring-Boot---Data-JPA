package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Course;
import com.spring.boot.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}