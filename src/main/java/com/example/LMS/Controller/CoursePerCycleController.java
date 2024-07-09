package com.example.LMS.Controller;

import com.example.LMS.Models.entity.CoursePerCycle;
import com.example.LMS.Service.imp.CoursePerCycleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-per-cycle")
public class CoursePerCycleController {

    @Autowired
    private CoursePerCycleServiceImp coursePerCycleService;

    @GetMapping
    public List<CoursePerCycle> getAllCoursePerCycles() {
        return coursePerCycleService.getAllCoursePerCycles();
    }
//
//
//    @GetMapping("/{courseId}/{cycleId}")
//    public ResponseEntity<CoursePerCycle> getCoursePerCycleById(@PathVariable String courseId, @PathVariable String cycleId) {
//        CoursePerCycleId id = new CoursePerCycleId(courseId, cycleId);
//        CoursePerCycle coursePerCycle = coursePerCycleService.getCoursePerCycleById(id);
//        if (coursePerCycle != null) {
//            return ResponseEntity.ok(coursePerCycle.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


//    @PostMapping
//    public CoursePerCycle createCoursePerCycle(@RequestBody CoursePerCycle coursePerCycle) {
//        return coursePerCycleService.save(coursePerCycle);
//    }

//    @PutMapping("/{courseId}/{cycleId}")
//    public ResponseEntity<CoursePerCycle> updateCoursePerCycle(@PathVariable String courseId, @PathVariable String cycleId, @RequestBody CoursePerCycle coursePerCycleDetails) {
//        CoursePerCycleId id = new CoursePerCycleId(courseId, cycleId);
//        Optional<CoursePerCycle> coursePerCycle = coursePerCycleService.findById(id);
//
//        if (coursePerCycle.isPresent()) {
//            CoursePerCycle existingCoursePerCycle = coursePerCycle.get();
//            existingCoursePerCycle.setCourseStartDate(coursePerCycleDetails.getCourseStartDate());
//            existingCoursePerCycle.setCourseEndDate(coursePerCycleDetails.getCourseEndDate());
//            final CoursePerCycle updatedCoursePerCycle = coursePerCycleService.save(existingCoursePerCycle);
//            return ResponseEntity.ok(updatedCoursePerCycle);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @DeleteMapping("/{courseId}/{cycleId}")
//    public ResponseEntity<Void> deleteCoursePerCycle(@PathVariable String courseId, @PathVariable String cycleId) {
//        CoursePerCycleId id = new CoursePerCycleId(courseId, cycleId);
//        coursePerCycleService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
