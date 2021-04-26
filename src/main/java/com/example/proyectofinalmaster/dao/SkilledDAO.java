package com.example.proyectofinalmaster.dao;

import com.example.proyectofinalmaster.model.Skilled;
import java.util.List;

public interface SkilledDAO {

    List <Skilled> findByName (String name, int size, int pagination);
    List <Skilled> findByModality (String modality, int size, int pagination);
    List <Skilled> findByState (String state, int size,  int pagination);
    List <Skilled> findByScore (String score, int size, int pagination);
    List<Skilled> findAllSkilled(int size, int pagination);

    Skilled findSkilledId (Long id);
}
