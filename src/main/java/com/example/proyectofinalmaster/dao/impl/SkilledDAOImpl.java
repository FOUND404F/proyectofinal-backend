package com.example.proyectofinalmaster.dao.impl;

import com.example.proyectofinalmaster.dao.SkilledDAO;
import com.example.proyectofinalmaster.model.Skilled;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SkilledDAOImpl implements SkilledDAO {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Skilled> findAllSkilled(int size, int pagination) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
        Root<Skilled> root = criteria.from(Skilled.class);
        criteria.select(root);
        Query query = manager.createQuery(criteria);
        query.setMaxResults(size);//size
        query.setFirstResult(pagination);//pagination
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Skilled> findByName(String name, int size ,int pagination ) {
        if (name != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
            Root<Skilled> root = criteria.from(Skilled.class);
            criteria.select(root);
            criteria.where(builder.like(root.get("name"), name + "%"));
            Query query = manager.createQuery(criteria);
            query.setMaxResults(size);//size
            query.setFirstResult(pagination);//pagination
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Skilled> findByModality(String modality, int size ,int pagination) {
        if (modality != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
            Root<Skilled> root = criteria.from(Skilled.class);
            criteria.select(root);
            criteria.where(builder.like(root.get("modality"), modality + "%"));
            Query query = manager.createQuery(criteria);
            query.setMaxResults(size);//size
            query.setFirstResult(pagination);//pagination
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Skilled> findByState(String state, int size,int pagination) {
        if (state != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
            Root<Skilled> root = criteria.from(Skilled.class);
            criteria.select(root);
            criteria.where(builder.like(root.get("state"), state + "%"));
            Query query = manager.createQuery(criteria);
            query.setMaxResults(size);//size
            query.setFirstResult(pagination);//pagination
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Skilled> findByScore(String score, int size, int pagination) {
        if (score != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
            Root<Skilled> root = criteria.from(Skilled.class);
            criteria.select(root);
            criteria.where(builder.like(root.get("score"), score + "%"));
            Query query = manager.createQuery(criteria);
            query.setMaxResults(size);//size
            query.setFirstResult(pagination);//pagination
            manager.close();
            return query.getResultList();
        }
        return new ArrayList<>();
    }

    @Override
            public Skilled findSkilledId (Long id){

                CriteriaBuilder builder = manager.getCriteriaBuilder();
                CriteriaQuery<Skilled> criteriaSkilled2 = builder.createQuery(Skilled.class);
                Root<Skilled> root = criteriaSkilled2.from(Skilled.class);
                criteriaSkilled2.select(root);
                criteriaSkilled2.where(builder.equal(root.get("id"), id));

                return manager.createQuery(criteriaSkilled2).getSingleResult();
            }
        }