package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Course;
import com.spring.boot.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder().title("DSA").credit(4).build();

        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com")
                                            .course(course).build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
    }

}