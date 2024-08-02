package com.example.LMS.Models.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity

@Table (name = "testscore")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestScore {

    @Id
    @Column(name = "course_id", length = 10, nullable = false)
    private Long courseId;

    @Column(name = "cycle_id", length = 10, nullable = false)
    private Long cycleId;

    @Column(name = "test_no", nullable = false)
    private Long testNo;

    @Column(name = "student_id", length = 10, nullable = false)
    private Long studentId;

    @Column(name = "Score", precision = 5, nullable = false)
    private BigDecimal score;



    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_id" ,insertable = false, updatable = false),
            @JoinColumn(name = "cycle_id", insertable = false, updatable = false),
            @JoinColumn(name = "test_no", insertable = false, updatable = false)
    })
    private Tests tests;


    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

}