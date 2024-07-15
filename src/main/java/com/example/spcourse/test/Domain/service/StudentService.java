package com.example.spcourse.test.Domain.service;

import com.example.spcourse.test.Application.dto.request.CreateStudentDto;
import com.example.spcourse.test.Application.dto.response.StudentGeneralDto;
import com.example.spcourse.test.Domain.entity.Student;
import com.example.spcourse.test.External.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    public ResponseEntity<StudentGeneralDto> getStudent(Integer id) {
        StudentGeneralDto studentGeneralDto = new StudentGeneralDto();
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentGeneralDto.setId(student.getId());
            studentGeneralDto.setName(student.getName());
            studentGeneralDto.setGrade(student.getGrade());
            return ResponseEntity.ok(studentGeneralDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Student> addStudent(CreateStudentDto createStudentDto) {
        Student student = new Student();
        student.setName(createStudentDto.getName());
        student.setAddress(createStudentDto.getAddress());
        student.setEmail(createStudentDto.getEmail());
        student.setGrade(createStudentDto.getGrade());
        studentRepository.save(student);
        ResponseEntity<Student> responseEntity = ResponseEntity.ok(student);
        return responseEntity;
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student delete successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateStudent(Integer id, String newName) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            log.info("student found");
            Student student = optionalStudent.get();
            student.setName(newName);
            studentRepository.save(student);
            return ResponseEntity.ok("student updated successfully");
        }else {
//            return ResponseEntity.notFound().build();
            throw new RuntimeException("student not found");
        }
    }
}
