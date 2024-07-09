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
    public Enrollment getEnrollmentById(String courseId, String cycleId, String studentId) {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setCourseId(Long.parseLong(courseId));
        enrollmentId.setCycleId(Long.parseLong(cycleId));  // Assuming cycleId is Long
        enrollmentId.setStudentId(Long.parseLong(studentId));

        return enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }


    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }


    @Override
    public Enrollment updateEnrollment(String courseId, String cycleId, String studentId, Enrollment enrollment) {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setCourseId(Long.parseLong(courseId));
        enrollmentId.setStudentId(Long.parseLong(studentId));
//        enrollmentId.setCycleId(Long.parseLong(cycleId));   // ??

        Enrollment existingEnrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        existingEnrollment.setIsCanceled(enrollment.getIsCanceled());
        existingEnrollment.setCancellationReason(enrollment.getCancellationReason());

        return enrollmentRepository.save(existingEnrollment);
    }

    @Override
    public void deleteEnrollment(String courseId, String cycleId, String studentId) {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setCourseId(Long.parseLong(courseId));
        enrollmentId.setStudentId(Long.parseLong(studentId));
//            enrollmentId.setCycleId(Long.parseLong(cycleId)); // ??
        enrollmentRepository.deleteById(enrollmentId);
    }
}
