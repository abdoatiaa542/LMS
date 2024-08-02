package com.example.LMS.Service.utils;


import java.util.List;

import com.example.LMS.Models.entity.TestId;
import com.example.LMS.Models.entity.Tests;

public interface TestsService {
    List<Tests> getAllTests();

    Tests getTestById(TestId testId);

    Tests saveTest(Tests test);

    void deleteTest(Long courseId, Long cycleId, Long testNo);
}