package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusCodeRepository extends JpaRepository<StatusCode, Integer> {
}
