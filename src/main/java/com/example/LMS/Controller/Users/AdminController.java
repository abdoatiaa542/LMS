package com.example.LMS.Controller.Users;

import com.example.LMS.Models.dto.AdminDto;
import com.example.LMS.Models.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.example.LMS.Models.entity.Admin;
import com.example.LMS.Service.utils.Users.AdminService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;


    @GetMapping("/all")
    public List<AdminDto> loadAdmin() {
        List<Admin> admins = adminService.getAllAdmins();
        if (admins != null) {
            return adminMapper.toDtoList(admins);
        }
        return Collections.emptyList();
    }

    @PostMapping("/save")
    public ResponseEntity<AdminDto> saveAdmin(@RequestBody AdminDto adminDto) {
        // map dto to entity
        // save the entity
        // return the saved entity
        AdminDto savedAdmin = adminService.saveAdmin(adminDto);
        return new ResponseEntity(savedAdmin, HttpStatus.CREATED);
    }


}