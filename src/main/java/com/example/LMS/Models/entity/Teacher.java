package com.example.LMS.Models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;



    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 30)
    private String phoneNo;

    @Column(nullable = false, length = 100)
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> teacherAuthorities;



    @ManyToMany(mappedBy = "teachers")
    private List<CoursePerCycle> coursePerCycles;


    @OneToMany(mappedBy = "teacher")
    private List<Class> classes;



    public Teacher() {

    }

    public Teacher(Long teacherId, String name, String email, String phoneNo, List<CoursePerCycle> coursePerCycles, String password, List<String> teacherAuthorities) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.coursePerCycles = coursePerCycles;
        this.password = password;
        this.teacherAuthorities = teacherAuthorities;
    }


}