package com.example.spcourse.test.Application.dto.response;

import com.example.spcourse.test.Domain.entity.Student;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectGeneralDto {
    private Integer id;
    Set<Student> enrolledStudent = new HashSet<>();
    private String name;
}
