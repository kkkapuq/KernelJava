package com.example.sisproject.domain.subject.controller;

import com.example.sisproject.domain.student.model.StudentRequest;
import com.example.sisproject.domain.subject.model.SubjectDto;
import com.example.sisproject.domain.subject.model.SubjectScoreDto;
import com.example.sisproject.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    // 전체 과목 조회
    @GetMapping("/")
    public String subjects (Model model) {
        List<SubjectDto> subjectList = subjectService.getSubjectList();
        model.addAttribute("subjectList", subjectList);
        return "subject/subjectList";
    }

    // 과목 수강생 학점 조회
    @GetMapping("/{id}")
    public String subject (Model model, @PathVariable int id) {
        List<SubjectScoreDto> subjectScoreList = subjectService.getSubjectScore(id);
        model.addAttribute("subjectScoreList", subjectScoreList);
        return "subject/subjectScoreList";
    }

    // 과목 추가
    @PostMapping("/new")
    public String createSubject (Model model) {
        return "home";
    }

    // 점수 저장
    @PostMapping("/enroll")
    public String createStudentSubject(StudentRequest request) {
        subjectService.saveStudentScore(request);

        return "redirect:/";
    }
}
