package com.example.sisproject.domain.student.controller;

import com.example.sisproject.domain.student.model.StudentDto;
import com.example.sisproject.domain.student.model.StudentRequest;
import com.example.sisproject.domain.student.service.StudentService;
import com.example.sisproject.domain.subject.model.SubjectDto;
import com.example.sisproject.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final SubjectService subjectService;

    // 학생 추가 화면이동
    @GetMapping("/new")
    public String createForm(){
        return "student/createStudentForm";
    }

    // 학생 추가
    @PostMapping("/new")
    public String create(StudentRequest request) {
        studentService.createStudent(request);

        return "redirect:/";
    }

    // 수강 신청
    @GetMapping("/subject")
    public String createStudentSubjectForm(Model model) {
        List<StudentDto> studentDtoList = studentService.getStudentList();
        List<SubjectDto> subjectDtoList = subjectService.getSubjectList();
        model.addAttribute("studentDtoList", studentDtoList);
        model.addAttribute("subjectDtoList", subjectDtoList);
        return "student/createStudentSubjectForm";
    }
}
