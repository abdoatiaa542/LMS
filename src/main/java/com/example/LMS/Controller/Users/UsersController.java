package com.example.LMS.Controller.Users;

import com.example.LMS.Models.dto.UsersDto;
import com.example.LMS.Models.entity.Users;
import com.example.LMS.Models.mappers.AdminMapper;
import com.example.LMS.Service.utils.Users.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

//    Admin Role
//    Role: ROLE_ADMIN
//    Authorities:
//    MANAGE_USERS: Add, update, or remove users (teachers and students).
//    MANAGE_COURSES: Oversee the creation, update, and deletion of courses.
//    VIEW_REPORTS: Access various reports related to the system.

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // get all admins
    @GetMapping("/all")
    public List<UsersDto> getAllAsdmin() {
        System.out.println(" i am in controller klmfgggggggggggggggggggggggggggggg");
        List<Users> users = adminService.getAllAdmins();
        if (users != null) {
            return adminMapper.toDtoList(adminService.getAllAdmins());

        }
        return Collections.emptyList();
    }
// get by id
    @GetMapping("get_by_id/{id}")
    public ResponseEntity<UsersDto> getAdminById(@PathVariable("id") Long id) {
        Users users = adminService.getAdminById(id);
        if (users != null) {
            return ResponseEntity.ok(adminMapper.toDto(users));
        }
        return ResponseEntity.notFound().build();
    }


    // registeration  >>  save admins
    @PostMapping("/register")
    public ResponseEntity<String> registeruser(@RequestBody UsersDto usersDto) {
        try {
            System.out.println(" i am in controller ");
            Users entity = adminMapper.toEntity(usersDto);
            String encodedPassword = passwordEncoder.encode(entity.getPassword());
            entity.setPassword(encodedPassword);
            Users savedadmin = adminService.savaAdmin(entity);

            if (savedadmin.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user registration failed");
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    // update admin
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable("id") Long id, @RequestBody UsersDto usersDto) {
        try {
//            System.out.println("Updating admin with ID: " + id);
            if (adminService.getAdminById(id) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }
            Users users = adminMapper.toEntity(usersDto);
            users.setId(id);
            adminService.savaAdmin(users);
            return ResponseEntity.ok("Admin updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Admin update failed");
        }
    }


    // delete admin

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long id) {
        try {
            System.out.println("Deleting admin with ID: " + id);
            Users existingUsers = adminService.getAdminById(id);

            if (existingUsers == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
            }

            adminService.deleteAdmin(id);
            return ResponseEntity.ok("Admin deleted successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Admin deletion failed");
        }
    }


}