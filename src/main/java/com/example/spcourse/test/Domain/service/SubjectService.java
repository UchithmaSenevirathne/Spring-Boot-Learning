package com.example.spcourse.test.Domain.service;

import com.example.spcourse.test.Application.dto.request.CreateSubjectDto;
import com.example.spcourse.test.Application.dto.response.SubjectGeneralDto;
import com.example.spcourse.test.External.repositories.SubjectRepository;
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
    public ResponseEntity<SubjectGeneralDto> getSubject(Integer id) {
        SubjectGeneralDto subjectGeneralDto = new SubjectGeneralDto();
        Optional<Subject> optionalSubject = subjectRepository.findById(id);

        if (optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            subjectGeneralDto.setId(subject.getId());
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
}