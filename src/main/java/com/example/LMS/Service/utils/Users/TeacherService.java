package com.example.LMS.Service.utils.Users;


import java.util.List;

import com.example.LMS.Models.entity.Teacher;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher loadTeacher(String username);
    Teacher getTeacherById(String id);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(String id, Teacher teacher);

    void deleteTeacher(String id);

}