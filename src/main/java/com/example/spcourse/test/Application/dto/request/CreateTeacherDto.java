package com.example.spcourse.test.Application.dto.request;

import com.example.spcourse.test.Domain.entity.Subject;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CreateTeacherDto {
    private Set<Subject> subjects = new HashSet<>();
    private String name;
}
