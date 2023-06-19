package com.example.minidoorayproject.repository;

import com.example.minidoorayproject.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByProject_ProjectId(Integer projectId);

    Tag findByTagName(String tagName);
}