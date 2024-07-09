package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.AttendanceId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link AttendanceId}
 */
@Value
public class AttendanceIdDto implements Serializable {
    ClassIdDto classId;
    Long studentId;
}