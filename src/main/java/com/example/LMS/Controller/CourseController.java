package com.example.LMS.Controller;

import com.example.LMS.Models.dto.CourseDto;
import com.example.LMS.Models.entity.Course;
import com.example.LMS.Models.mappers.CourseMapper;
import com.example.LMS.Models.mappers.CoursePerCycleMapper;
import com.example.LMS.Service.imp.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/all")
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        if (courses != null) {
            return courseMapper.toDtoList(courses);
        }
        return Collections.emptyList();
    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        Optional<Course> course = Optional.ofNullable(courseService.getCourseById(id));
        if (course.isPresent()) {
            return ResponseEntity.ok(courseMapper.toDto(course.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/create")
    public CourseDto createCourse(@RequestBody CourseDto courseDto) {
        Course course = courseService.createCourse(courseMapper.toEntity(courseDto));
        return courseMapper.toDto(course);
    }

    @PutMapping("/update/{id}")
    public CourseDto createCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        Course course = courseService.updateCourse(id, courseMapper.toEntity(courseDto));
        return courseMapper.toDto(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}