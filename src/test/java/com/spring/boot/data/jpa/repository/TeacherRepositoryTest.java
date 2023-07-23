package com.spring.boot.data.jpa.repository;

import com.spring.boot.data.jpa.entity.Course;
import com.spring.boot.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder().title("DBA").credit(2).build();
        Course courseJAVA = Course.builder().title("JAVA").credit(4).build();

        Teacher teacher = Teacher.builder().firstName("nishantha").lastName("gamage")
//                                .courses(List.of(courseDBA, courseJAVA))
                                .build();

        teacherRepository.save(teacher);
    }
}