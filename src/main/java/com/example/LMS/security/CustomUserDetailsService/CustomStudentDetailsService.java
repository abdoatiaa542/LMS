package com.example.LMS.security.CustomUserDetailsService;

import com.example.LMS.Models.entity.Student;
import com.example.LMS.Reposatory.Users.StudentRepository;
import com.example.LMS.security.CustomUserDetails.CustomStudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomStudentDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = userRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found"));
        return new CustomStudentDetails(student);

    }
}