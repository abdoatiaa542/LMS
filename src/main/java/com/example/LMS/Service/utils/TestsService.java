package com.example.LMS.Service.utils;


import java.util.List;
import com.example.LMS.Models.entity.Tests;

public interface TestsService {
    List<Tests> getAllTests();
//    Tests getTestById(String courseId, String cycleId, int testNo);
    Tests saveTest(Tests test);
//    void deleteTest(String courseId, String cycleId, int testNo);
}