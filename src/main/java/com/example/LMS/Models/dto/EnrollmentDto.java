package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Enrollment;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link Enrollment}
 */
@Value
public class EnrollmentDto implements Serializable {
    EnrollmentIdDto id;
    Date enrollmentDate;
    Boolean isCanceled;
    String cancellationReason;
}