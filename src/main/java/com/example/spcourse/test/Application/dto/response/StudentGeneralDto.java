package com.example.spcourse.test.Application.dto.response;

import com.example.spcourse.test.Domain.entity.Subject;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentGeneralDto {
    private Integer id;
    private Set<Subject> enrolledSubject = new HashSet<>();
    private String name;
    private Integer grade;
}
