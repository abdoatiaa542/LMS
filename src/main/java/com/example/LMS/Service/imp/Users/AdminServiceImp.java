package com.example.LMS.Service.imp.Users;

import com.example.LMS.Models.entity.Users;
import com.example.LMS.Models.mappers.AdminMapper;
import com.example.LMS.Reposatory.Users.UsersRepository;
import com.example.LMS.Service.utils.Users.AdminService;
import com.example.LMS.security.CustomUserDetailsService.CustomAdminDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private CustomAdminDetailsService adminDetailsService;

    @Autowired
    private UsersRepository adminRepo;

    @Autowired
    private AdminMapper adminMapper;


//    public Admin loadAdmin(String email) {
//        UserDetails userDetails = adminDetailsService.loadUserByUsername(email);
//        return Admin.builder()
//                .username(userDetails.getUsername())
//                .password(userDetails.getPassword())
//                .build();
//    }


    @Override
    public Users savaAdmin(Users users) {
        return adminRepo.save(users);
    }

    @Override
    public List<Users> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public Users getAdminById(Long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public void deleteAdmin(Long id) {

        adminRepo.deleteById(id);

    }

}