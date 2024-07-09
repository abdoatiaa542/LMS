package com.example.LMS.Service.imp;


import java.util.List;

import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Models.entity.TestScoreId;
import com.example.LMS.Reposatory.TestScoresRepository;
import com.example.LMS.Service.utils.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestScoreServiceImpl implements TestScoreService {

    @Autowired
    private TestScoresRepository testScoreRepository;

    @Override
    public List<TestScore> getAllTestScores() {
        return testScoreRepository.findAll();
    }

    @Override
    public TestScore getTestScoreById(TestScoreId id) {
        return testScoreRepository.findById(id).orElse(null);
    }

    @Override
    public TestScore createTestScore(TestScore testScore) {
        return testScoreRepository.save(testScore);
    }

//    @Override
//    public TestScore updateTestScore(TestScoreId id, TestScore testScore) {
//
//
//    }

//    @Override
//    public TestScore updateTestScore(TestScoreId id, TestScore testScore) {
//        testScore.setTestScoreId(id);
//        return testScoreRepository.save(testScore);
//    }

    @Override
    public void deleteTestScore(TestScoreId id) {
        testScoreRepository.deleteById(id);
    }
}