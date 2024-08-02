package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_id", insertable = false, updatable = false),
            @JoinColumn(name = "cycle_id", insertable = false, updatable = false),
    })
    private CoursePerCycle coursePerCycle;


    private Date enrollmentDate;
    private Boolean isCanceled;
    private String cancellationReason;


}