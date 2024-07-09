package com.example.LMS.Service.utils;



import java.util.List;
import com.example.LMS.Models.entity.Course;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(String id);

    Course createCourse(Course course);

    Course updateCourse(String id, Course course);

    void deleteCourse(String id);
}
