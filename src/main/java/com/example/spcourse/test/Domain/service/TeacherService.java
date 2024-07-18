package com.example.spcourse.test.Domain.service;

import com.example.spcourse.test.Application.dto.request.CreateTeacherDto;
import com.example.spcourse.test.Application.dto.response.TeacherGeneralDto;
import com.example.spcourse.test.Domain.entity.Teacher;
import com.example.spcourse.test.External.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public ResponseEntity<TeacherGeneralDto> getTeacher(Integer id) {
        TeacherGeneralDto teacherGeneralDto = new TeacherGeneralDto();
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);

        if (optionalTeacher.isPresent()){
            Teacher teacher = optionalTeacher.get();
            teacherGeneralDto.setId(teacher.getId());
            teacherGeneralDto.setName(teacher.getName());
            return ResponseEntity.ok(teacherGeneralDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Teacher> addTeacher(CreateTeacherDto createTeacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(createTeacherDto.getName());
        teacherRepository.save(teacher);
        ResponseEntity<Teacher> responseEntity = ResponseEntity.ok(teacher);
        return responseEntity;
    }
}
