package com.example.testsecurity.sec.service;

import com.example.testsecurity.sec.entities.AppRole;
import com.example.testsecurity.sec.entities.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public AppUser addNewUser(AppUser appUser);
    public AppRole addNewRole(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    List<AppUser> listUsers();
}
