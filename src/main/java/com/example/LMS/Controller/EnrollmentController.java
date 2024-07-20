package com.example.LMS.Controller;




import java.util.Collections;
import java.util.List;

import com.example.LMS.Models.dto.EnrollmentDto;
import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.mappers.EnrollmentMapper;
import com.example.LMS.Service.utils.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private EnrollmentMapper enrollmentMapper;



    @GetMapping("/all")
    public List<EnrollmentDto> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        if (enrollments != null) {
            return enrollmentMapper.toDtoList(enrollments);
        }
        return Collections.emptyList();
    }







    @GetMapping("/{courseId}/{cycleId}/{studentId}")
    public Enrollment getEnrollmentById(@PathVariable String courseId, @PathVariable String cycleId, @PathVariable String studentId) {
        return enrollmentService.getEnrollmentById(courseId, cycleId, studentId);
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @PutMapping("/{courseId}/{cycleId}/{studentId}")
    public Enrollment updateEnrollment(@PathVariable String courseId, @PathVariable String cycleId, @PathVariable String studentId, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(courseId, cycleId, studentId, enrollment);
    }

    @DeleteMapping("/{courseId}/{cycleId}/{studentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String courseId, @PathVariable String cycleId, @PathVariable String studentId) {
        enrollmentService.deleteEnrollment(courseId, cycleId, studentId);
        return ResponseEntity.noContent().build();
    }


}