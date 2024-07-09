package com.example.LMS.Service.imp;


import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Models.entity.CoursePerCycleId;
import com.example.LMS.Reposatory.CoursePerCycleRepository;
import com.example.LMS.Service.utils.CoursePerCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePerCycleServiceImp implements CoursePerCycleService {

    @Autowired
    private CoursePerCycleRepository coursePerCycleRepository;


    @Override
    public List<CoursePerCycle> getAllCoursePerCycles() {
        return coursePerCycleRepository.findAll();
    }

    @Override
    public CoursePerCycle getCoursePerCycleById(CoursePerCycleId id) {
        return coursePerCycleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("CoursePerCycle not found"));
    }

    @Override
    public CoursePerCycle createCoursePerCycle(CoursePerCycle coursePerCycle) {
        return coursePerCycleRepository.save(coursePerCycle);
    }

    @Override
    public CoursePerCycle updateCoursePerCycle(CoursePerCycleId id, CoursePerCycle coursePerCycle) {
        CoursePerCycle existingCoursePerCycle = coursePerCycleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("CoursePerCycle not found"));
        existingCoursePerCycle.setCourseStartDate(coursePerCycle.getCourseStartDate());
        existingCoursePerCycle.setCourseEndDate(coursePerCycle.getCourseEndDate());
        return coursePerCycleRepository.save(existingCoursePerCycle);
    }


    @Override
    public void deleteCoursePerCycle(CoursePerCycleId id) {
        coursePerCycleRepository.deleteById(id);
    }
}