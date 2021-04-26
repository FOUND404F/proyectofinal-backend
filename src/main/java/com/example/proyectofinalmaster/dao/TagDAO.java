package com.example.proyectofinalmaster.dao;

import com.example.proyectofinalmaster.model.Tags;
import java.util.List;

public interface TagDAO {

    List<Tags> findByName (String name, int size, int pagination);
    List<Tags> findAllTags (int size, int pagination);

    Tags findTagId (Long id);
}
