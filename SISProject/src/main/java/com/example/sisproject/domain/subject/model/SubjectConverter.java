package com.example.sisproject.domain.subject.model;

import com.example.sisproject.domain.subject.db.SubjectEntity;
import com.example.sisproject.domain.subject.db.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectConverter {
    private final SubjectRepository subjectRepository;

    public SubjectDto toDto(SubjectEntity subjectEntity){
        return SubjectDto.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .build();
    }

}
