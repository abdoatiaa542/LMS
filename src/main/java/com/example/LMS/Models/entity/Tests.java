package com.example.LMS.Models.entity;


import java.sql.Time;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Tests {

    @EmbeddedId
    private TestId id;

    private Date testDate;
    private Time testTime;
    private String agenda;


    @OneToMany(mappedBy = "tests")
    List<TestScore> testScores;




    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "course_id", referencedColumnName = "course_id" , insertable = false, updatable = false),
            @JoinColumn(name = "cycle_id", referencedColumnName = "cycle_id" , insertable = false, updatable = false),
    })
    private CoursePerCycle coursePerCycle;

}
