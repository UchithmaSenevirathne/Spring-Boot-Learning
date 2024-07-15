package com.example.spcourse.test.Application.controllers;

import com.example.spcourse.test.Application.dto.response.StudentGeneralDto;
import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.Domain.service.StudentService;
import com.example.spcourse.test.External.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam Integer id){
        //*****RequestParam
        return studentService.getStudent(id);
//        ResponseEntity<Integer> responseEntity = new ResponseEntity<>(id, HttpStatus.OK);
//        return responseEntity;

        //*****pathvariable
//        return id.toString();

//        Optional<Student> student = studentRepository.findByName("uchi");
//        if (student.isPresent()) {
//            return student.get();
//        }else {
//            return new Student();
//        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(){

    }
}
