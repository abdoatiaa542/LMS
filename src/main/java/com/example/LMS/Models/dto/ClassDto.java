package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Class;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * DTO for {@link Class}
 */
@Value
public class ClassDto implements Serializable {
    ClassIdDto id;
    String title;
    Date date;
    Time startTime;
    Time endTime;
}