package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.EnrollmentId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link EnrollmentId}
 */
@Value
public class EnrollmentIdDto implements Serializable {
    Long studentId;
    Long courseId;
    Long cycleId;
}