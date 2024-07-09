package com.example.LMS.Models.dto;

import com.example.LMS.Models.dto.TestScoreIdDto;
import com.example.LMS.Models.entity.TestScore;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link TestScore}
 */
@Value
public class TestScoreDto implements Serializable {
    TestScoreIdDto id;
    BigDecimal score;
}