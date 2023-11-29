package com.example.sisproject.domain.subject.service;

import com.example.sisproject.domain.grade.BasicEvaluation;
import com.example.sisproject.domain.grade.GradeEvaluation;
import com.example.sisproject.domain.grade.MajorEvaluation;
import com.example.sisproject.domain.grade.PassFailEvaluation;
import com.example.sisproject.domain.student.db.StudentEntity;
import com.example.sisproject.domain.student.db.StudentRepository;
import com.example.sisproject.domain.student.model.StudentRequest;
import com.example.sisproject.domain.subject.db.ScoreEntity;
import com.example.sisproject.domain.subject.db.ScoreRepository;
import com.example.sisproject.domain.subject.db.SubjectEntity;
import com.example.sisproject.domain.subject.db.SubjectRepository;
import com.example.sisproject.domain.subject.model.SubjectConverter;
import com.example.sisproject.domain.subject.model.SubjectDto;
import com.example.sisproject.domain.subject.model.SubjectScoreDto;
import com.example.sisproject.global.util.Define;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectConverter subjectConverter;
    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;

    // 과목 조회
    public List<SubjectDto> getSubjectList() {
        List<SubjectEntity> entityList = subjectRepository.findAll();
        return entityList.stream()
                .map(subjectConverter::toDto)
                .toList();
    }

    // 과목별 점수 조회
    public List<SubjectScoreDto> getSubjectScore(int id) {
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow();
        List<ScoreEntity> scoreEntityList = scoreRepository.findAllBySubject(subjectEntity);

        return scoreEntityList.stream().map(scoreEntity -> {
            SubjectScoreDto dto = new SubjectScoreDto();
            dto.setName(scoreEntity.getStudent().getName());
            dto.setId(scoreEntity.getStudent().getId());
            dto.setMajorSubject(scoreEntity.getStudent().getMajorSubject());
            dto.setGrade(getGrade(scoreEntity.getSubject(), scoreEntity));
            dto.setPoint(scoreEntity.getPoint());
            return dto;
        }).collect(Collectors.toList());

    }

    // 학점 계산기
    public String getGrade(SubjectEntity subject, ScoreEntity score) {
        GradeEvaluation gradeEvaluation;

        if (subject.getGradeType() == Define.AB_TYPE && score.getSubject().equals(subject)) {
            gradeEvaluation = new MajorEvaluation();
        } else if(subject.getGradeType() == Define.AB_TYPE){
            gradeEvaluation = new BasicEvaluation();
        } else {
            gradeEvaluation = new PassFailEvaluation();
        }
        return gradeEvaluation.getGrade(score.getPoint());
    }

    // 학생 점수 저장
    public ScoreEntity saveStudentScore(StudentRequest request) {
        StudentEntity student = studentRepository.findById(request.getId()).orElseThrow();
        SubjectEntity subject = subjectRepository.findById(request.getSubjectId()).orElseThrow();
        ScoreEntity scoreEntity = ScoreEntity.builder()
                .student(student)
                .point(request.getPoint())
                .subject(subject)
                .build();

        return scoreRepository.save(scoreEntity);
    }
}
