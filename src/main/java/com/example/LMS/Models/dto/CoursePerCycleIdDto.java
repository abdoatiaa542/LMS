package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.CoursePerCycleId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link CoursePerCycleId}
 */
@Value
public class CoursePerCycleIdDto implements Serializable {
    Long courseId;
    Long cycleId;
}