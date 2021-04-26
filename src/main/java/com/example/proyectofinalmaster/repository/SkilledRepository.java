package com.example.proyectofinalmaster.repository;

import com.example.proyectofinalmaster.model.Skilled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkilledRepository extends JpaRepository <Skilled, Long> {
}
