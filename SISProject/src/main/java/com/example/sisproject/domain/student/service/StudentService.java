package com.example.sisproject.domain.student.service;

import com.example.sisproject.domain.student.db.StudentEntity;
import com.example.sisproject.domain.student.db.StudentRepository;
import com.example.sisproject.domain.student.model.StudentDto;
import com.example.sisproject.domain.student.model.StudentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // 학생 추가
    public StudentEntity createStudent(StudentRequest request) {
        StudentEntity entity = StudentEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .majorSubject(request.getMajorSubject())
                .build();
        return studentRepository.save(entity);
    }

    // 학생 리스트 전달
    public List<StudentDto> getStudentList() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return studentEntityList.stream()
                .map(studentEntity -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setId(studentEntity.getId());
                    studentDto.setName(studentEntity.getName());

                    return studentDto;
                }).collect(Collectors.toList());
    }
}
