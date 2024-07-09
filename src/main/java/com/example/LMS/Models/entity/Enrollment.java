package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Setter
@Getter
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_id"),
            @JoinColumn(name = "cycle_id"),
    })
    private CoursePerCycle coursePerCycle;


    private Date enrollmentDate;
    private Boolean isCanceled;
    private String cancellationReason;


}