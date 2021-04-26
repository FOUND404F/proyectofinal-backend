package com.example.proyectofinalmaster;

import com.example.proyectofinalmaster.model.Skilled;
import com.example.proyectofinalmaster.model.Tags;
import com.example.proyectofinalmaster.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.*;
import javax.xml.stream.events.Comment;
import java.util.List;

public class QueryTest {


    @Test
    @DisplayName("Paging Results")
    public void pagingResults() {

        int límite = 5;
        int página = 0;
        Tags etiqueta = new Tags(null, null, null);
        String nombre = "Manuel";
        String modalidad = "front";
        String estado = "pending";
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Skilled> criteria = builder.createQuery(Skilled.class);
        Root<Skilled> root = criteria.from(Skilled.class);
        criteria.select(root);

        Predicate name = builder.equal(root.get("name"), nombre);
        Predicate modality = builder.equal(root.get("modality"), modalidad);
        Predicate state = builder.equal(root.get("state"), estado);


        criteria.where(builder.and(name, modality, state));

        Query<Skilled> query = session.createQuery(criteria);
        query.setMaxResults(límite); // size
        query.setFirstResult(página); // pagination

        List<Skilled> skilleds = query.list();
        System.out.println(skilleds.size());
        for (Skilled skilled :  skilleds) {
            List<Tags> tags =skilled.getTags();
            boolean exist = false;
            for(Tags tag : tags){
                if(tag.getId() == etiqueta.getId()){
                    exist = true;
                    break;
                }else{
                    exist = false;
                }
            }
            if(!exist){
                skilleds.remove(skilled);
            }
        };
        System.out.println(skilleds.size());
        session.close();
    }
}
