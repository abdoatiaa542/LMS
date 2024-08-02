package com.example.LMS.Controller;


import com.example.LMS.Models.dto.EnrollmentDto;
import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.entity.EnrollmentId;
import com.example.LMS.Models.mappers.EnrollmentMapper;
import com.example.LMS.Service.utils.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/enrollments")
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

    @GetMapping("/get_by_id/{course_id}/{cycle_id}/{student_id}")
    public ResponseEntity<EnrollmentDto> getEnrollmentById(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long student_id) {

        Optional<Enrollment> enrollment = Optional.ofNullable(enrollmentService.getEnrollmentById(new EnrollmentId(course_id, cycle_id, student_id)));

        if (enrollment.isPresent()) {
            return ResponseEntity.ok(enrollmentMapper.toDto(enrollment.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDto);
        return ResponseEntity.ok(enrollmentMapper.toDto(enrollmentService.createEnrollment(enrollment)));
    }

    @PutMapping("/update")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long student_id, @RequestBody EnrollmentDto enrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDto);
        enrollment.setId(new EnrollmentId(course_id, cycle_id, student_id));
        return ResponseEntity.ok(enrollmentMapper.toDto(enrollmentService.createEnrollment(enrollment)));
    }


    @DeleteMapping("/delete/{course_id}/{cycle_id}/{student_id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long course_id, @PathVariable Long cycle_id, @PathVariable Long student_id) {
        enrollmentService.deleteEnrollment(new EnrollmentId(course_id, cycle_id, student_id));
        return ResponseEntity.ok().build();
    }

}