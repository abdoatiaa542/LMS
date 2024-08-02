package com.example.LMS.security.CustomUserDetailsService;

import com.example.LMS.Models.entity.Users;
import com.example.LMS.Reposatory.Users.StudentRepository;
import com.example.LMS.Reposatory.Users.TeacherRepository;
import com.example.LMS.Reposatory.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// GET ENTITY FROM DB.
// CONVERT ENTITY TO USER DETAILS "to can spring security"
@Service
public class CustomAdminDetailsService implements UserDetailsService {

    private final String USER_ROLE_PREFIX = "ROLE_";

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = usersRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();

            List<GrantedAuthority> authorities = users.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority))
                    .collect(Collectors.toList());

            authorities.add(new SimpleGrantedAuthority("ROLE_" + users.getRole()));
            System.out.println(authorities);

            return new User(users.getEmail(), users.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User not found");
    }
}

//        Optional<Student> student = studentRepository.findByEmail(username);
//        if (student.isPresent()) {
//            Student studentEntity = student.get();
//            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(USER_ROLE_PREFIX + "STUDENT"));
//            return new User(studentEntity.getName(), studentEntity.getPassword(), authorities);
//        }
//
//        Optional<Teacher> teacher = teacherRepository.findByEmail(username);
//        if (teacher.isPresent()) {
//            Teacher teacherEntity = teacher.get();
//            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(USER_ROLE_PREFIX + "TEACHER"));
//            return new User(teacherEntity.getName(), teacherEntity.getPassword(), authorities);
//        }
//
//
//        throw new UsernameNotFoundException("User not found");
//    }
//
//
//
//}