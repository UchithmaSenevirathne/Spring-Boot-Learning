package com.example.spcourse.test.Application.controllers;

import com.example.spcourse.test.Application.dto.request.CreateSubjectDto;
import com.example.spcourse.test.Application.dto.response.SubjectGeneralDto;
import com.example.spcourse.test.Domain.entity.Subject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.spcourse.test.Domain.service.SubjectService;

@RestController
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;

    @GetMapping("/getSubject")
    public ResponseEntity<SubjectGeneralDto> getSubject(@RequestParam Integer id){
        return subjectService.getSubject(id);
    }

    @PostMapping("/addSubject")
    public ResponseEntity<Subject> addSubject(@RequestBody CreateSubjectDto createSubjectDto){
        return subjectService.addSubject(createSubjectDto);
    }

    @PutMapping("/{subjectId}/student/{studentId}")
    Subject enrollStudentToSubject(
            @PathVariable Integer subjectId,
            @PathVariable Integer studentId
    ){
        return subjectService.enrollStudentToSubject(subjectId,studentId);
    }
}
