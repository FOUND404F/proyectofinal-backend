package com.example.proyectofinalmaster.service.impl;

import com.example.proyectofinalmaster.dao.SkilledDAO;
import com.example.proyectofinalmaster.model.Skilled;
import com.example.proyectofinalmaster.repository.SkilledRepository;
import com.example.proyectofinalmaster.service.SkilledService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkilledServiceImpl implements SkilledService {

    private final SkilledDAO skilledDAO;

    private final SkilledRepository skilledRepository;

    public SkilledServiceImpl(SkilledDAO skilledDAO, SkilledRepository skilledRepository) {
        this.skilledDAO = skilledDAO;
        this.skilledRepository = skilledRepository;
    }

    @Override
    public List<Skilled> findAllSkilled(int size, int pagination) {
        List<Skilled> skilleds = skilledDAO.findAllSkilled(size,pagination);
        return skilleds;
    }

    @Override
    public List<Skilled> findByName(String name, int size,  int pagination) {
        return skilledDAO.findByName(name, size, pagination);
    }

    @Override
    public List<Skilled> findByModality(String modality, int size, int pagination) {
        return skilledDAO.findByModality(modality, size, pagination);
    }

    @Override
    public List<Skilled> findByState(String state, int size, int pagination) {
        return skilledDAO.findByState(state, size, pagination);
    }

    @Override
    public List<Skilled> findByScore (String score, int size, int pagination) {
        return skilledDAO.findByScore (score, size, pagination);
    }


    @Override
    public Skilled findSkilledId(Long id) {
        Skilled results = this.skilledDAO.findSkilledId(id);
        System.out.println("--------");
        return results;
    }

    @Override
    public Skilled createSkilled(Skilled skilleddata) {
        return skilledRepository.save(skilleddata);
    }

    @Override
    public Skilled updateSkilled(Skilled skilleddata2) {
        return skilledRepository.save(skilleddata2);
    }


    @Override
    public Skilled deleteSkilled(Long id) {
        Skilled skilled = this.skilledDAO.findSkilledId(id);
        skilledRepository.deleteById(id);
        return skilled;
    }
}
