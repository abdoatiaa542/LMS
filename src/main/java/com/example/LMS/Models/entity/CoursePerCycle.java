package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "course_per_cycle")
@Setter
@Getter
@NoArgsConstructor // ..
@AllArgsConstructor  // ..
public class CoursePerCycle {


    @EmbeddedId
    private CoursePerCycleId id;
    private Date courseStartDate;
    private Date courseEndDate;


    @OneToMany(mappedBy = "coursePerCycle")
    private List<Enrollment> enrollments;


    @ManyToOne
    @JoinColumn(name = "cycle_id" ,insertable = false, updatable = false)
    private Cycle cycle;


    @ManyToMany
    @JoinTable(
            name = "teachers_per_course",
            joinColumns = {
                    @JoinColumn(name = "course_id" , referencedColumnName = "course_id" ),
                    @JoinColumn(name = "cycle_id" , referencedColumnName = "cycle_id" )
            },
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    )
    private List<Teacher> teachers;



    @ManyToOne
    @JoinColumn(name = "course_id" ,  insertable = false, updatable = false)
    private Course course;


    @OneToMany(mappedBy = "coursePerCycle")
    private List<Class> classes;



    @OneToMany(mappedBy = "coursePerCycle")
    private List<Tests> tests;



}