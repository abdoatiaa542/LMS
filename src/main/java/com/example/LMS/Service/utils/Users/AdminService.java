package com.example.LMS.Service.utils.Users;

import com.example.LMS.Models.dto.AdminDto;
import com.example.LMS.Models.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

     AdminDto loadAdmin(String username);
//    Admin getAdminById(Long id);
    AdminDto saveAdmin(AdminDto admindto);
//    Admin updateAdmin(String id, Admin admin);
//    void deleteAdmin(String id);

}