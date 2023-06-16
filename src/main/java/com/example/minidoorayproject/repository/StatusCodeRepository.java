package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StatusCodeRepository extends JpaRepository<StatusCode, Integer> {

    StatusCode findByCodeId(Integer codeId);

    StatusCode findByCodeName(String codeName);

}
