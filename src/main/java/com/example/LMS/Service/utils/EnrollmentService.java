package com.example.LMS.Service.utils;


import java.util.List;
import com.example.LMS.Models.entity.Enrollment;
public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(String courseId, String cycleId, String studentId);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(String courseId, String cycleId, String studentId, Enrollment enrollment);
    void deleteEnrollment(String courseId, String cycleId, String studentId);
}