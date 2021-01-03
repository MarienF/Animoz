package com.animoz.service;

import com.animoz.controller.SoigneurDto;
import com.animoz.model.Soigneur;
import com.animoz.repository.SoigneurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoigneurService {

    @Autowired
    private SoigneurRepository soigneurRepository;

    public List<Soigneur> getListSoigneur(){
        return soigneurRepository.getListSoigneur();
    }

    public Soigneur addSoigneur(SoigneurDto soigneurDto){
        Soigneur soigneur = new Soigneur();
        soigneur.setNom(soigneurDto.getNom());
        soigneur.setNumero(soigneurDto.getNumero());
        soigneur.setDateRecrutement(soigneurDto.getDateRecrutement());
        soigneurRepository.add(soigneur);
        return soigneur;
    }
}
