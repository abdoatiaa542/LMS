package com.example.LMS.Service.utils;



import java.util.List;
import com.example.LMS.Models.entity.Course;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
