package com.example.LMS.Service.utils.Users;


import java.util.List;

import com.example.LMS.Models.entity.Teacher;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher loadTeacher(String username);
    Teacher getTeacherById(Long id);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Long id, Teacher teacher);

    void deleteTeacher(Long id);

}