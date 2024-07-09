package com.example.LMS.Service.imp;

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

//    @Override
//    public Tests getTestById(String courseId, String cycleId, int testNo) {
//        return testsRepository.findById(new TestId(courseId, cycleId, testNo)).orElse(null);
//    }

    @Override
    public Tests saveTest(Tests test) {
        return testsRepository.save(test);
    }

//    @Override
//    public void deleteTest(String courseId, String cycleId, int testNo) {
//        testsRepository.deleteById(new TestId(courseId, cycleId, testNo));
//    }
}