package com.example.LMS.Controller;

import com.example.LMS.Models.dto.CoursePerCycleDto;
import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Models.entity.CoursePerCycleId;
import com.example.LMS.Models.mappers.CoursePerCycleMapper;
import com.example.LMS.Service.imp.CoursePerCycleServiceImp;
import com.example.LMS.Service.utils.CoursePerCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/course_per_cycle")
public class CoursePerCycleController {

    @Autowired
    private CoursePerCycleService coursePerCycleService;
    @Autowired
    private CoursePerCycleMapper coursePerCycleMapper;


    @GetMapping("/all")
    public List<CoursePerCycleDto> getAllCoursePerCycle() {
        List<CoursePerCycle> coursePerCycles = coursePerCycleService.getAllCoursePerCycles();
        if (coursePerCycles != null) {
            return coursePerCycleMapper.toDtoList(coursePerCycles);
        }
        return Collections.emptyList();
    }


    @GetMapping("/get_by_id/{courseId}/{cycleId}")
    public ResponseEntity<CoursePerCycleDto> getCoursePerCycleById(@PathVariable Long courseId, @PathVariable Long cycleId) {
        Optional<CoursePerCycle> coursePerCycle = Optional.ofNullable(coursePerCycleService.getCoursePerCycleById(new CoursePerCycleId(courseId, cycleId)));
        if (coursePerCycle.isPresent()) {
            return ResponseEntity.ok(coursePerCycleMapper.toDto(coursePerCycle.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // create endpoint to save course_per_cycle

    @PostMapping("/save")
    public ResponseEntity<CoursePerCycleDto> createCoursePerCycle(@RequestBody CoursePerCycleDto coursePerCycleDto) {
        CoursePerCycle coursePerCycle = coursePerCycleMapper.toEntity(coursePerCycleDto);
        CoursePerCycle createdCoursePerCycle = coursePerCycleService.createCoursePerCycle(coursePerCycle);
        return ResponseEntity.ok(coursePerCycleMapper.toDto(createdCoursePerCycle));

    }

    // create endpoint to update course_per_cycle
    @PutMapping("/update/{courseId}/{cycleId}")
    public ResponseEntity<CoursePerCycleDto> updateCoursePerCycle(@PathVariable Long courseId, @PathVariable Long cycleId, @RequestBody CoursePerCycleDto coursePerCycleDto) {
        CoursePerCycle coursePerCycle = coursePerCycleMapper.toEntity(coursePerCycleDto);
        CoursePerCycle updatedCoursePerCycle = coursePerCycleService.updateCoursePerCycle(new CoursePerCycleId(courseId, cycleId), coursePerCycle);
        return ResponseEntity.ok(coursePerCycleMapper.toDto(updatedCoursePerCycle));

    }
    // create endpoint to delete course_per_cycle

    @DeleteMapping("/delete/{courseId}/{cycleId}")
    public ResponseEntity<Void> deleteCoursePerCycle(@PathVariable Long courseId, @PathVariable Long cycleId) {
        coursePerCycleService.deleteCoursePerCycle(new CoursePerCycleId(courseId, cycleId));
        return ResponseEntity.noContent().build();
    }

}


