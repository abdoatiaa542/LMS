package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Attendance;
import lombok.Value;

import java.io.Serializable;
import java.sql.Time;

/**
 * DTO for {@link Attendance}
 */
@Value
public class AttendanceDto implements Serializable {
    AttendanceIdDto id;
    Time timeArrive;
    Time timeLeave;
}