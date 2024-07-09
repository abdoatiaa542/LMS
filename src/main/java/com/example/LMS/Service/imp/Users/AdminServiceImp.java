package com.example.LMS.Service.imp.Users;

import com.example.LMS.Models.dto.AdminDto;
import com.example.LMS.Models.entity.Admin;
import com.example.LMS.Models.mappers.AdminMapper;
import com.example.LMS.Reposatory.Users.AdminRepository;
import com.example.LMS.Service.utils.Users.AdminService;
import com.example.LMS.security.CustomUserDetailsService.CustomAdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private CustomAdminDetailsService adminDetailsService;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private AdminMapper adminMapper;

    public AdminDto loadAdmin(String username) {
        UserDetails userDetails = adminDetailsService.loadUserByUsername(username);
        return AdminDto.builder()
                .username(userDetails.getUsername())
                .password(userDetails.getPassword())
                .build();
    }


    public AdminDto saveAdmin(AdminDto admindto) {
        Admin admin = adminMapper.toEntity(admindto);
        Admin savedAdmin = adminRepo.save(admin);
        return adminMapper.toDto(savedAdmin);
    }

}