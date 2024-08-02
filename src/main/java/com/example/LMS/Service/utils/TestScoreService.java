package com.example.LMS.Service.utils;


import com.example.LMS.Models.entity.TestScore;

import java.util.List;

public interface TestScoreService {
    List<TestScore> getAllTestScores();
    TestScore getTestScoreById(Long id);
    TestScore createTestScore(TestScore testScore);
    void deleteTestScore(Long id);
}