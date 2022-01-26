package com.example.hruser.repositories;

import com.example.hruser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

     User findByEmail(String email);
}
