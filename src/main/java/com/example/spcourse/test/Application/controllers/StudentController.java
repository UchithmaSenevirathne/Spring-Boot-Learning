package com.example.spcourse.test.Application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/list")
    public String getStudent(){
        return "student list";
    }

    @PostMapping("/add")
    public String addStudent(){
        return "student added";
    }
}
