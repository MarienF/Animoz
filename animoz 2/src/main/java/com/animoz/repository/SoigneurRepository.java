package com.animoz.repository;

import com.animoz.model.Soigneur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SoigneurRepository {

    @Autowired
    private EntityManager em;

    public List<Soigneur> getListSoigneur(){
        return em.createQuery("select s from Soigneur s order by s.nom", Soigneur.class).getResultList();
    }

    public void add(Soigneur s){
        Soigneur soigneur = new Soigneur();
        soigneur.setNom(s.getNom());
        soigneur.setNumero(s.getNumero());
        soigneur.setDateRecrutement(s.getDateRecrutement());
        em.persist(soigneur);
    }
}
