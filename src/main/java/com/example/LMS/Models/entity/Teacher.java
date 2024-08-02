package com.example.LMS.Models.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
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

    @Column( nullable = false, length = 30)
    private String phone_no;

    @Column(nullable = false, length = 100)
    private String password;


    @ManyToMany(mappedBy = "teachers")
    private List<CoursePerCycle> coursePerCycles;


    @OneToMany(mappedBy = "teacher")
    private List<Class> classes;



}