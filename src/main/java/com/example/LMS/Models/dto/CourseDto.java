package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Course;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Course}
 */
@Value
public class CourseDto implements Serializable {
    Long course_id;
    String courseDescription;
    String abstractText;
    String bibliography;
}