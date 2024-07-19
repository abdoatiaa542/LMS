package com.example.LMS.Service.imp.Users;

import com.example.LMS.Reposatory.Users.TeacherRepository;
import com.example.LMS.Service.utils.Users.TeacherService;
import com.example.LMS.security.CustomUserDetailsService.CustomTeacherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.LMS.Models.entity.Teacher;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CustomTeacherDetailsService teacherDetailsService;


    public Teacher loadTeacher(String username) {
        UserDetails userDetails = teacherDetailsService.loadUserByUsername(username);
        return Teacher.builder()
                .name(userDetails.getUsername())
                .password(userDetails.getPassword())
                .teacherAuthorities(userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .build();
    }


    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.setName(teacherDetails.getName());
        teacher.setEmail(teacherDetails.getEmail());
        teacher.setPhoneNo(teacherDetails.getPhoneNo());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherRepository.delete(teacher);
    }
}