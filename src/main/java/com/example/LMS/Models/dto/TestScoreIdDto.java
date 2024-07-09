package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.TestScoreId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestScoreId}
 */
@Value
public class TestScoreIdDto implements Serializable {
    Long courseId;
    Long cycleId;
    Long testNo;
    Long studentId;
}