package com.example.LMS.security.CustomUserDetailsService;

import com.example.LMS.Models.entity.Teacher;
import com.example.LMS.Reposatory.Users.TeacherRepository;
import com.example.LMS.security.CustomUserDetails.CustomTeacherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomTeacherDetailsService implements UserDetailsService {
    @Autowired
    private TeacherRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = userRepo.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Teacher not found"));
        return new CustomTeacherDetails(teacher);
    }
}