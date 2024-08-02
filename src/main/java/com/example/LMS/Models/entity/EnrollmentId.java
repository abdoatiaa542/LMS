package com.example.LMS.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentId implements Serializable {
    @Column(name = "student_id", insertable = false, updatable = false, nullable = false)
    private Long studentId;
    @Column(name = "course_id", insertable = false, updatable = false, nullable = false)
    private Long courseId;
    @Column(name = "cycle_id", insertable = false, updatable = false, nullable = false)
    private Long cycleId;

}