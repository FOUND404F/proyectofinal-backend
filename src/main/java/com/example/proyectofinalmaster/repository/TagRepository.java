package com.example.proyectofinalmaster.repository;

import com.example.proyectofinalmaster.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository <Tags, Long> {
}
