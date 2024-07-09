package com.example.LMS.Models.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;




@Embeddable
@Getter
@Setter
public class TestId implements Serializable {

    @Column(name = "course_id" , insertable=false, updatable=false)
    private Long courseId;
    @Column(name = "cycle_id", insertable=false, updatable=false)
    private Long cycleId;

    @Column(name = "test_no", insertable=false, updatable=false)
    private Long testNo;


}