package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  User getUserByIdIs(String id);
}
