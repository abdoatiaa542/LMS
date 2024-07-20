package com.example.LMS.Models.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class AttendanceId implements Serializable {

//    @Embedded
    @Column(name = "class_id")
    private ClassId classId;

    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;






    public AttendanceId(ClassId classId, Long studentId) {
        this.classId = classId;
        this.studentId = studentId;
    }

    public AttendanceId() {

    }


}