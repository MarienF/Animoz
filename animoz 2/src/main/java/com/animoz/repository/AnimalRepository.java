package com.animoz.repository;

import com.animoz.model.Animal;
import com.animoz.model.Espece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AnimalRepository {

    @Autowired
    private EntityManager em;

    public List<Animal> getListAnimaux(){
        return em.createQuery("select a from Animal a order by a.nom", Animal.class).getResultList();
    }

    public List getListAnimauxLike(String filtre){
        return em.createQuery("select a from Animal a where a.nom like ?1")
                .setParameter(1, filtre)
                .getResultList();
    }

    public List<Espece> getAllEspece(){
        return em.createQuery("select e from Espece e").getResultList();
    }

    public Espece getEspeceSelect(String nom) {
        return (Espece) em.createQuery("select a from Espece a where a.nom = ?1")
                .setParameter(1, nom)
                .getSingleResult();
    }

    @Transactional
    public void add(Animal a) {
        try {
            Animal animal = new Animal();
            animal.setNom(a.getNom());
            animal.setDescription(a.getDescription());
            animal.setRegime(a.getRegime());
            animal.setEspece(a.getEspece());
            em.persist(animal);
        }
        finally {
            em.close();
        }
    }
}
