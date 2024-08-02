package com.example.LMS.Service.imp;

import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;
import com.example.LMS.Reposatory.TestRepository;
import com.example.LMS.Service.utils.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestsServiceImpl implements TestsService {

    @Autowired
    private TestRepository testsRepository;

    @Override
    public List<Tests> getAllTests() {
        return testsRepository.findAll();
    }

    @Override
    public Tests getTestById(TestId testId) {

        return testsRepository.findById(testId).orElse(null);

    }

    @Override
    public Tests saveTest(Tests test) {
        return testsRepository.save(test);
    }

    @Override
    public void deleteTest(Long courseId, Long cycleId, Long testNo) {

    }


}