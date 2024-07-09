package com.example.LMS.Models.dto;

import com.example.LMS.Models.dto.TestIdDto;
import com.example.LMS.Models.entity.Tests;
import lombok.Value;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * DTO for {@link Tests}
 */
@Value
public class TestsDto implements Serializable {
    TestIdDto id;
    Date testDate;
    Time testTime;
    String agenda;
}