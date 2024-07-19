package com.example.LMS.Models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class TestScoreId implements Serializable {


    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "cycle_id")
    private Long cycleId;
    @Column(name = "test_no")
    private Long testNo;
    @Column(name = "student_id"  )
    private Long studentId;


    public TestScoreId() {}

    public TestScoreId(Long courseId, Long cycleId, Long testNo, Long studentId) {
        this.courseId = courseId;
        this.cycleId = cycleId;
        this.testNo = testNo;
        this.studentId = studentId;
    }


}