package com.example.sisproject.domain.subject.db;

import com.example.sisproject.domain.student.db.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "score")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private StudentEntity student;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private SubjectEntity subject;

    private int point;
}
