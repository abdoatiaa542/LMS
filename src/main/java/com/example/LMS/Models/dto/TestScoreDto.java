package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.TestScore;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestScore}
 */
@Value
public class TestScoreDto implements Serializable {
    Long courseId;
    Long cycleId;
    Long testNo;
    Long studentId;
    Double score;

}