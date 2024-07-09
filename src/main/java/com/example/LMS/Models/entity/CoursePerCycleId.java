package com.example.LMS.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CoursePerCycleId implements Serializable{

    @Column(name = "course_id" , insertable=false, updatable=false , nullable = false)
    private Long courseId;

    @Column(name = "cycle_id" , insertable=false, updatable=false , nullable = false)
    private Long cycleId;


    public CoursePerCycleId() {
    }

    public CoursePerCycleId(Long courseId, Long cycleId) {
        this.courseId = courseId;
        this.cycleId = cycleId;
    }
}