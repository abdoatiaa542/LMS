package com.example.LMS.Service.imp;


import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.entity.EnrollmentId;
import com.example.LMS.Service.utils.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LMS.Reposatory.EnrollmentRepository;


import java.util.List;

@Service
public class EnrollmentServiceImp implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }


    @Override
    public Enrollment getEnrollmentById(EnrollmentId enrollmentId) {
        return enrollmentRepository.findById(enrollmentId).orElse(null);
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }



    @Override
    public void deleteEnrollment(EnrollmentId enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }

}
