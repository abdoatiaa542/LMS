package com.example.LMS.Reposatory;

import com.example.LMS.Models.entity.TestScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestScoresRepository extends JpaRepository<TestScore, Long> {
}
