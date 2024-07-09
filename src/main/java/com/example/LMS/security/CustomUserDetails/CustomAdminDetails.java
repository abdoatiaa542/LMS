package com.example.LMS.security.CustomUserDetails;




import com.example.LMS.Models.entity.Role;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Builder
public class CustomAdminDetails implements UserDetails {

    private final long id;
    private final String username;
    private final String email;
    private final String password;
    private final Role roles;
    private List<String> adminAuthorities = new ArrayList<>();

//    private final Admin admin;

    public CustomAdminDetails(long id, String username, String email, String password, Role roles , List<String> userAuthorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.adminAuthorities = userAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        getUserAuthorities().forEach(userAuthority -> {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userAuthority));
        });
        return simpleGrantedAuthorities;
    }

    public List<String> getUserAuthorities() {
        return adminAuthorities;
    }




    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}