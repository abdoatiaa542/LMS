package com.example.LMS.Models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Setter
@Getter
public class Class {


    @EmbeddedId
    private ClassId id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    @Column( name = "teacher_id", nullable = false , insertable = false, updatable = false)
    private Long teacherId;



















    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"   , nullable = false , insertable = false, updatable = false)  //
    private Teacher teacher;



    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false),
            @JoinColumn(name = "cycle_id", referencedColumnName = "cycle_id", insertable = false, updatable = false),
    })
    private CoursePerCycle coursePerCycle;



    @OneToMany(mappedBy = "classes")
    private List<Attendance> attendances;










}