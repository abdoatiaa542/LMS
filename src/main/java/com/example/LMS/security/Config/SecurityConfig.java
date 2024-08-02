package com.example.LMS.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        try {
            http.csrf((csrfConfigurer) -> csrfConfigurer.disable())
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/v1/users/**").hasRole("ADMIN")
                            .requestMatchers("/v1/students/**").hasRole("ADMIN")
                            .requestMatchers("/v1/teachers/**").hasRole("ADMIN")
                            .requestMatchers("/v1/attendance/**").hasAnyRole("ADMIN", "TEACHER")
                            .requestMatchers("/v1/categories/**").permitAll()
                            .requestMatchers("/v1/classes/**").hasRole("TEACHER")
                            .requestMatchers("/v1/courses/all", "/v1/courses/get_by_id/{id}").permitAll()
                            .requestMatchers("/v1/courses/create", "/v1/courses/update/{id}", "/api/courses/delete/{id}").hasAnyRole("ADMIN", "TEACHER")
                            .requestMatchers("/v1/course_per_cycle/all", "/v1/course_per_cycle/get_by_id/{id}").permitAll()                            // انا مش فاهم حاجه هو احنا لما نيجي نتعامل هنتعامل مع انهي واحد فيهم دا ولا ال course
                            .requestMatchers("/v1/course_per_cycle/create", "/v1/course_per_cycle/update/{id}", "/api/course_per_cycle/delete/{id}").hasAnyRole("ADMIN", "TEACHER")
                            .requestMatchers("/api/cycles/**").permitAll()
                            .requestMatchers("/v1/tests/**").hasAnyRole("STUDENT", "TEACHER") // studemnts
                            .requestMatchers("/v1/test-scores/**").hasAnyRole("STUDENT", "TEACHER", "ADMIN")
                            .requestMatchers("/v1/enrollments/**").permitAll()

                            .anyRequest().authenticated()

                    );
            http.formLogin(withDefaults());
            http.httpBasic(withDefaults());
            return http.build();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}

// course  >>
// TEACHER & ADMIN :  Create , Update , Delete


//
//Teacher Authorities
//Role: ROLE_TEACHER
//Authorities:
//        CREATE_COURSE: Create new courses.
//        UPDATE_COURSE: Update course details.
//        DELETE_COURSE: Delete courses.
//        VIEW_ENROLLMENTS: View students enrolled in their courses.
//        ASSIGN_GRADES: Assign grades to students.
//        MANAGE_CLASSES: Schedule and manage class sessions.

//Student Authorities
//Role: ROLE_STUDENT
//Authorities:
//           ENROLL_COURSE: Enroll in available courses.
//           VIEW_GRADES: View their grades.
//           ATTEND_CLASSES: Mark attendance for classes.
//           VIEW_COURSE_CONTENT: Access course materials and resources.
//           SUBMIT_ASSIGNMENTS: Submit assignments.


//Admin Role

//Role: ROLE_ADMIN
//Authorities:
//MANAGE_USERS: Add, update, or remove users (teachers and students).
//MANAGE_COURSES: Oversee the creation, update, and deletion of courses.
//VIEW_REPORTS: Access various reports related to the system.