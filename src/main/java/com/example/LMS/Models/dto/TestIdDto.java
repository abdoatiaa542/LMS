package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.TestId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TestId}
 */
@Value
public class TestIdDto implements Serializable {
    Long courseId;
    Long cycleId;
    Long testNo;
}