package com.example.spcourse.test.Application.dto.response;

import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.Domain.entity.Teacher;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SubjectGeneralDto {
    private Integer id;
    Set<Student> enrolledStudent = new HashSet<>();
    private Teacher teacher;
    private String name;
}
