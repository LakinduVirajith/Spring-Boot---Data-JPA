package com.spring.boot.data.jpa.service;

import com.spring.boot.data.jpa.entity.Student;
import com.spring.boot.data.jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }
}
