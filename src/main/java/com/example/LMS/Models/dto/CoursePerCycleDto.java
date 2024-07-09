package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.CoursePerCycle;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link CoursePerCycle}
 */
@Value
public class CoursePerCycleDto implements Serializable {
    CoursePerCycleIdDto id;
    Date courseStartDate;
    Date courseEndDate;
}