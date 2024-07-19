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

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/{username}")
    public AdminDto getAdmin(@PathVariable String username) {
    }

    @GetMapping("/load")
    public ResponseEntity<AdminDto> loadAdmin(@RequestParam String username) {
        System.out.println("انا جوه الميثود ");
        try {
            System.out.println("انا جوه التراي");   
            AdminDto adminDto = adminService.loadAdmin(username);
//            System.out.println(adminDto);
            return new ResponseEntity(adminDto, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            System.out.println("كسك احمرررررررررررررررر");
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST); // Return 400 Bad Request
        }
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