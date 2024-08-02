package com.example.LMS.Models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "role", nullable = false)
    private String role;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_authorities", joinColumns = @JoinColumn(name = "users_id"))
    @Column(name = "name")
    private List<String> authorities;



}