package com.example.LMS.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Getter
@Setter
public class ClassId implements Serializable {

    @Column(name = "course_id" , insertable=false, updatable=false)
     Long courseId;
    @Column(name = "cycle_id", insertable=false, updatable=false)
    Long cycleId;
    @Column(name = "class_no", insertable=false, updatable=false)
    Long classNo;

    public ClassId(Long courseId, Long cycleId, Long classNo) {
        this.courseId = courseId;
        this.cycleId = cycleId;
        this.classNo = classNo;
    }


    public ClassId() {

    }


    // Getters and setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public Long getClassNo() {
        return classNo;
    }

    public void setClassNo(Long classNo) {
        this.classNo = classNo;
    }
}