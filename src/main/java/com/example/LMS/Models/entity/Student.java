package com.example.LMS.Models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // This is the primary key
    private String name;
    private String email;
    private Date birthDate;
    private String phoneNumber;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> studentAuthorities;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<TestScore> testScores;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<Attendance> attendances;


    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Enrollment> enrollments;


    public Student() {
    }


    public Student(Long id, String name, String email, Date birthDate, String phoneNumber, String password, List<String> studentAuthorities, List<TestScore> testScores, List<Attendance> attendances, List<Enrollment> enrollments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.studentAuthorities = studentAuthorities;
        this.testScores = testScores;
        this.attendances = attendances;
        this.enrollments = enrollments;
    }


}