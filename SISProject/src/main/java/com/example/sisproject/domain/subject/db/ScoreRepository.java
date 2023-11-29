package com.example.sisproject.domain.subject.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {
    List<ScoreEntity> findAllBySubject(SubjectEntity subjectEntity);
}
