package com.example.spcourse.test.Domain.service;

import com.example.spcourse.test.Application.dto.request.CreateSubjectDto;
import com.example.spcourse.test.Application.dto.response.SubjectGeneralDto;
import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.Domain.entity.Teacher;
import com.example.spcourse.test.External.repositories.StudentRepository;
import com.example.spcourse.test.External.repositories.SubjectRepository;
import com.example.spcourse.test.External.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.spcourse.test.Domain.entity.Subject;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    public ResponseEntity<SubjectGeneralDto> getSubject(Integer id) {
        SubjectGeneralDto subjectGeneralDto = new SubjectGeneralDto();
        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        if (optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            subjectGeneralDto.setId(subject.getId());
            subjectGeneralDto.setEnrolledStudent(subject.getEnrolledStudent());
            subjectGeneralDto.setName(subject.getName());
            return ResponseEntity.ok(subjectGeneralDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Subject> addSubject(CreateSubjectDto createSubjectDto) {
        Subject subject = new Subject();
        subject.setName(createSubjectDto.getName());
        subjectRepository.save(subject);
        ResponseEntity<Subject> responseEntity = ResponseEntity.ok(subject);
        return responseEntity;
    }

    public Subject enrollStudentToSubject(Integer subjectId, Integer studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }

    public Subject enrollTeacherToSubject(Integer subjectId, Integer teacherId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();
        subject.enrollTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
