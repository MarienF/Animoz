package com.animoz.service;

import com.animoz.controller.AnimalDto;
import com.animoz.controller.SoigneurDto;
import com.animoz.model.Animal;
import com.animoz.model.Espece;
import com.animoz.model.Soigneur;
import com.animoz.repository.AnimalRepository;
import com.animoz.repository.SoigneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getListAnimaux(){
        return animalRepository.getListAnimaux();
    }

    public List getListAnimauxLike(String filtre) {
        return animalRepository.getListAnimauxLike("%" + filtre + "%");
    }

    @Transactional
    public Animal addAnimal(AnimalDto animalDto){
        Animal animal = new Animal();
        animal.setNom(animalDto.getNom());
        animal.setDescription((animalDto.getDescription()));
        animal.setRegime(animalDto.getRegime());
        animal.setEspece((Espece) animalRepository.getEspeceSelect(animalDto.getEspece()));
        animalRepository.add(animal);
        return animal;
    }

    public List<Espece> getAllEspeces() {
        return animalRepository.getAllEspece();
    }
}
