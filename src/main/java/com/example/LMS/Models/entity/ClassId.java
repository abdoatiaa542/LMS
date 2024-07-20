package com.example.LMS.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Setter
@Getter
public class ClassId implements Serializable {

    @Column(name = "course_id" , insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long courseId;

    @Column(name = "cycle_id", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cycleId;

    @Column(name = "class_no", insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long classNo;


    public ClassId(Long courseId, Long cycleId, Long classNo) {
        this.courseId = courseId;
        this.cycleId = cycleId;
        this.classNo = classNo;
    }


    public ClassId() {

    }

}