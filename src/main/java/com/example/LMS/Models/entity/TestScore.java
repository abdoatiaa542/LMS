package com.example.LMS.Models.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class TestScore {

    @EmbeddedId
    private TestScoreId id;

    @Column(nullable = false, precision = 5, scale = 2)
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


    public TestScore(TestScoreId id, BigDecimal score) {
        this.id = id;
        this.score = score;
    }

    public TestScore() {

    }
}