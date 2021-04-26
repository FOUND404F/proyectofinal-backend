package com.example.proyectofinalmaster.service.impl;

import com.example.proyectofinalmaster.dao.TagDAO;
import com.example.proyectofinalmaster.model.Tags;
import com.example.proyectofinalmaster.repository.TagRepository;
import com.example.proyectofinalmaster.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    private final TagRepository tagRepository;

    public TagServiceImpl(TagDAO tagDAO, TagRepository tagRepository) {
        this.tagDAO = tagDAO;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tags> findAllTags(int size, int pagination) {
        List<Tags> tags = tagDAO.findAllTags(size,pagination);
        return tags;
    }

    @Override
    public List<Tags> findByName(String name, int size,  int pagination) {
        return tagDAO.findByName(name, size, pagination);
    }

    @Override
    public Tags findTagId(Long id) {
        Tags results = this.tagDAO.findTagId(id);
        System.out.println("--------");
        return results;
    }

    @Override
    public Tags createTag(Tags tagdata) {
        return tagRepository.save(tagdata);
    }

    @Override
    public Tags updateTag (Tags tagdata2) {
        return tagRepository.save(tagdata2);
    }

    @Override
    public Tags deleteTag(Long id) {
        Tags tag = this.tagDAO.findTagId(id);
        tagRepository.deleteById(id);
        return tag;
    }
}
