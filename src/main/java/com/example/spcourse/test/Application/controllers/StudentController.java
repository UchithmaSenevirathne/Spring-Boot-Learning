package com.example.spcourse.test.Application.controllers;

import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.External.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    @GetMapping("/list")
    public Student getStudent(){
        Optional<Student> student = studentRepository.findById(1);
        if (student.isPresent()) {
            return student.get();
        }else {
            return new Student();
        }
    }

    @PostMapping("/add")
    public String addStudent(){
        return "student added";
    }
}
