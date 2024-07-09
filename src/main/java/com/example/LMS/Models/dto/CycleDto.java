package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Cycle;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link Cycle}
 */
@Value
public class CycleDto implements Serializable {
    Long id;
    String description;
    Date startDate;
    Date endDate;
    Date vacationStartDate;
    Date vacationEndDate;
}