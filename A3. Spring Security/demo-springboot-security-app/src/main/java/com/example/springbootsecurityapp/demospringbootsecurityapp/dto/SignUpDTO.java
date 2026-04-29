package com.example.springbootsecurityapp.demospringbootsecurityapp.dto;

import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.enums.Role;
import lombok.Data;

import java.security.Permission;
import java.util.Set;

@Data
public class SignUpDTO {

    private String email;
    private String password;
    private String name;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
