package com.example.sisproject.domain.subject.db;

import com.example.sisproject.global.util.Define;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "subject")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int gradeType;

    public SubjectEntity(String name, int id){
        this.name = name;
        this.id = id;
        this.gradeType = Define.AB_TYPE;   //기본적으로 A, B 타입
    };
}
