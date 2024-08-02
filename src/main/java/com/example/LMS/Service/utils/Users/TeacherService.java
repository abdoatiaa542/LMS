package com.example.LMS.Service.utils.Users;


import java.util.List;

import com.example.LMS.Models.entity.Teacher;

public interface TeacherService {

    Teacher savaTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(long id, Teacher teacher);

    void deleteTeacher(Long id);

}