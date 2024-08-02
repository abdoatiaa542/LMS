package com.example.LMS.Service.utils;




import java.util.List;
import com.example.LMS.Models.entity.Class;
import com.example.LMS.Models.entity.ClassId;


public interface ClassService {
    List<Class> getAllClasses();
    Class getClassById(ClassId id);
    Class saveClass(Class sclass);
    void deleteClass(ClassId id);
}