package com.example.sisproject.domain.student.db;

import com.example.sisproject.domain.subject.db.ScoreEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "student")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String majorSubject;

    @OneToMany(mappedBy = "student")
    private List<ScoreEntity> scoreList = List.of();
}
