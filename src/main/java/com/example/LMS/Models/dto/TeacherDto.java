package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Teacher;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Teacher}
 */
@Value
public class TeacherDto implements Serializable {

    Long teacherId;
    String name;
    String email;
    String phone_no;
    String password;

}