package com.example.spcourse.test.Application.controllers;

import com.example.spcourse.test.Application.dto.request.CreateTeacherDto;
import com.example.spcourse.test.Application.dto.response.TeacherGeneralDto;
import com.example.spcourse.test.Domain.entity.Teacher;
import com.example.spcourse.test.Domain.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping("/getTeacher")
    public ResponseEntity<TeacherGeneralDto> getTeacher(@RequestParam Integer id){
        return teacherService.getTeacher(id);
    }

    @PostMapping("/addTeacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody CreateTeacherDto createTeacherDto){
        return teacherService.addTeacher(createTeacherDto);
    }
}
