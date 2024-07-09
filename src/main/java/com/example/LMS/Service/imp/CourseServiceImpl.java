package com.example.LMS.Service.imp;

import com.example.LMS.Service.utils.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;  // import the List class
import com.example.LMS.Models.entity.Course;
import com.example.LMS.Reposatory.CourseRepository;

@Service
public class CourseServiceImpl  implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        existingCourse.setCourseDescription(course.getCourseDescription());
        existingCourse.setAbstractText(course.getAbstractText());
        existingCourse.setBibliography(course.getBibliography());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}