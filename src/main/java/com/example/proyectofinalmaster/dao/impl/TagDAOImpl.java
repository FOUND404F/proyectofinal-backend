package com.example.proyectofinalmaster.dao.impl;

import com.example.proyectofinalmaster.dao.TagDAO;
import com.example.proyectofinalmaster.model.Tags;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Tags> findAllTags(int size, int pagination) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tags> criteria = builder.createQuery(Tags.class);
        Root<Tags> root = criteria.from(Tags.class);
        criteria.select(root);
        Query query = manager.createQuery(criteria);
        query.setMaxResults(size);//size
        query.setFirstResult(pagination);//pagination
        manager.close();
        return query.getResultList();
    }

    @Override
    public List<Tags> findByName(String name, int size ,int pagination ) {
        if (name != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Tags> criteria = builder.createQuery(Tags.class);
            Root<Tags> root = criteria.from(Tags.class);
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
    public Tags findTagId(Long id){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tags> criteriaTags2 = builder.createQuery(Tags.class);
        Root<Tags> root = criteriaTags2.from(Tags.class);
        criteriaTags2.select(root);
        criteriaTags2.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteriaTags2).getSingleResult();
    }
}
