package com.example.LMS.Models.dto;

import com.example.LMS.Models.entity.Student;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * DTO for {@link Student}
 */

@Value
public class StudentDto implements Serializable {
    Long id;
    String name;
    String email;
    Date birthDate;
    String phoneNumber;
    String password;
    List<String> studentAuthorities;
}