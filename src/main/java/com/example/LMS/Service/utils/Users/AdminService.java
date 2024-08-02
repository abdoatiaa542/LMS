package com.example.LMS.Service.utils.Users;

import com.example.LMS.Models.entity.Users;

import java.util.List;

public interface AdminService {



//    Admin loadAdmin(String email);// for  security not related with controller

    Users savaAdmin(Users users);
    List<Users> getAllAdmins();
    Users getAdminById(Long id);
    void deleteAdmin(Long id);

}