package com.spring.boot.data.jpa.controller;

import com.spring.boot.data.jpa.entity.Student;
import com.spring.boot.data.jpa.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public Student postStudent(@Valid @RequestBody Student student){
        LOGGER.info("post student data");
        return studentService.postStudent(student);
    }
}
