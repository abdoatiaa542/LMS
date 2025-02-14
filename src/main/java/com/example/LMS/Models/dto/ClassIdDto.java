package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.ClassId;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ClassId}
 */
@Value
public class ClassIdDto implements Serializable {
    Long courseId;
    Long cycleId;
    Long classNo;

    public ClassIdDto(Long courseId, Long cycleId, Long classNo) {
        this.courseId = courseId;
        this.cycleId = cycleId;
        this.classNo = classNo;
    }

}