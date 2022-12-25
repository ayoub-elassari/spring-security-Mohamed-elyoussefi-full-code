package com.example.testsecurity.sec.repo;

import com.example.testsecurity.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByusername(String username);
}
