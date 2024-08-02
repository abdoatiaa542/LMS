package com.example.LMS.Service.utils;


import java.util.List;

import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.entity.EnrollmentId;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();

    Enrollment getEnrollmentById(EnrollmentId enrollmentId);

    Enrollment createEnrollment(Enrollment enrollment);


    void deleteEnrollment(EnrollmentId enrollmentId);
}