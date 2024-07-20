package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Setter
@Getter
public class Attendance {

    @EmbeddedId
    private AttendanceId id;
    private Time timeArrive;
    private Time timeLeave;


    public Attendance() {

    }
    public Attendance(AttendanceId id, Time timeArrive, Time timeLeave) {
        this.id = id;
        this.timeArrive = timeArrive;
        this.timeLeave = timeLeave;
    }

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @MapsId("classId")
    @JoinColumns({
            @JoinColumn(name = "class_course_id", referencedColumnName = "course_id"),
            @JoinColumn(name = "class_cycle_id", referencedColumnName = "cycle_id"),
            @JoinColumn(name = "class_class_no", referencedColumnName = "class_no")
    })
    private Class classes;




}
