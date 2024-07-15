package com.example.spcourse.test.Application.controllers;

import com.example.spcourse.test.Application.dto.response.StudentGeneralDto;
import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.Domain.service.StudentService;
import com.example.spcourse.test.External.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@AllArgsConstructor //dependancy injection - constructor
public class StudentController {

    //dependancy injection - field
//    @Autowired
//    private StudentRepository studentRepository;

    //use student service
    private StudentService studentService;

    @GetMapping("/getStudent")
    public StudentGeneralDto getStudent(Integer id){
//        Optional<Student> student = studentRepository.findByName("uchi");
//        if (student.isPresent()) {
//            return student.get();
//        }else {
//            return new Student();
//        }
    }

    @PostMapping("/add")
    public String addStudent(){
        return "student added";
    }
}
