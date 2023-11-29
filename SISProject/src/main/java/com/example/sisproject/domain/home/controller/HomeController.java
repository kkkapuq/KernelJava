package com.example.sisproject.domain.home.controller;

import com.example.sisproject.domain.subject.model.SubjectDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    // 메인화면
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
}
