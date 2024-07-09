package com.example.LMS.security.CustomUserDetailsService;

import com.example.LMS.Models.entity.Role;
import com.example.LMS.Models.entity.Admin;
import com.example.LMS.Reposatory.Users.AdminRepository;
import com.example.LMS.security.CustomUserDetails.CustomAdminDetails;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Builder
public class CustomAdminDetailsService implements UserDetailsService {
    private final String USER_ROLE_PREFIX = "ROLE_";

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        // GET ENTITY FROM DB.
        // CONVERT ENTITY TO USER DETAILS "to can spring security"

        Optional<Admin> optionalAdmin = adminRepo.findByUsername(username);
        optionalAdmin.orElseThrow(() -> new UsernameNotFoundException("Admin not found"));
        Admin admin = optionalAdmin.get();
        CustomAdminDetails customAdmin = CustomAdminDetails.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .password(admin.getPassword())
                .roles(Role.ADMIN)
                .email(admin.getEmail())
                .adminAuthorities(new ArrayList<>())
                .build();

        customAdmin.getUserAuthorities().add(USER_ROLE_PREFIX + Role.ADMIN.name());
        return customAdmin;
    }
}