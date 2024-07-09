package com.example.LMS.Service.utils;

import java.util.List;
import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Models.entity.CoursePerCycleId;


public interface CoursePerCycleService {
    List<CoursePerCycle> getAllCoursePerCycles();
    CoursePerCycle getCoursePerCycleById(CoursePerCycleId id);
    CoursePerCycle createCoursePerCycle(CoursePerCycle coursePerCycle);
    CoursePerCycle updateCoursePerCycle(CoursePerCycleId id, CoursePerCycle coursePerCycle);
    void deleteCoursePerCycle(CoursePerCycleId id);
}