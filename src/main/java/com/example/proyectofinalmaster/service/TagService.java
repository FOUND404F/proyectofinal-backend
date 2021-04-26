package com.example.proyectofinalmaster.service;

import com.example.proyectofinalmaster.model.Tags;
import java.util.List;

public interface TagService {

    List<Tags> findAllTags (int size, int pagination);
    List<Tags> findByName (String name, int size, int pagination);

    Tags findTagId (Long id);

    Tags createTag (Tags tagdata);
    Tags updateTag (Tags tagdata2);
    Tags deleteTag (Long id);
}
