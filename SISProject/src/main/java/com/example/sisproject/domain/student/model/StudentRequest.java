package com.example.sisproject.domain.student.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentRequest {
    private int id;
    private String name;
    private String majorSubject;
    private String subject;
    private int subjectId;
    private int point;
}
