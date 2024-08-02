package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private Date birth_date;
    @Column(nullable = false, length = 30)
    private String phone_number;
    @Column(nullable = false, length = 100)
    private String password;


    @OneToMany(mappedBy = "student")
    List<TestScore> testScores;

    @OneToMany(mappedBy = "student")
    List<Attendance> attendances;


    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;



}