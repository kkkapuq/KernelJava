package com.example.sisproject.domain.subject.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class SubjectScoreDto {
    private String name;
    private int id;
    private String majorSubject;
    private int point;
    private String grade;
}
