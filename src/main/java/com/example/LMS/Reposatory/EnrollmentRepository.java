package com.example.LMS.Reposatory;

import com.example.LMS.Models.entity.Enrollment;
import com.example.LMS.Models.entity.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
}