package com.example.LMS.Service.imp;


import com.example.LMS.Models.entity.TestScore;
import com.example.LMS.Reposatory.TestScoresRepository;
import com.example.LMS.Service.utils.TestScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestScoreServiceImpl implements TestScoreService {

    @Autowired
    private TestScoresRepository testScoreRepository;

    @Override
    public List<TestScore> getAllTestScores() {
        return testScoreRepository.findAll();
    }

    @Override
    public TestScore getTestScoreById(Long id) {
        return testScoreRepository.findById(id).orElse(null);
    }

    @Override
    public TestScore createTestScore(TestScore testScore) {
        return testScoreRepository.save(testScore);
    }


    @Override
    public void deleteTestScore(Long id) {
        testScoreRepository.deleteById(id);
    }
}