package com.example.LMS.Service.utils;




import java.util.List;
import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Models.entity.TestScoreId;

public interface TestScoreService {
    List<TestScore> getAllTestScores();
    TestScore getTestScoreById(TestScoreId id);
    TestScore createTestScore(TestScore testScore);
//    TestScore updateTestScore(TestScoreId id, TestScore testScore);
    void deleteTestScore(TestScoreId id);
}