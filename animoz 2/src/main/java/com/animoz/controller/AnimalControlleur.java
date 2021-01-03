package com.animoz.controller;

import com.animoz.model.Animal;
import com.animoz.model.Regime;
import com.animoz.model.Soigneur;
import com.animoz.service.AnimalService;
import com.animoz.service.SoigneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;

@Controller
public class AnimalControlleur {
    @Autowired
    AnimalService animalService;

    // Afficher animaux
    @GetMapping(path = "/animaux")
    public String afficherListeAnimal(Model model){
        List<Animal> listAnimaux = animalService.getListAnimaux();
        model.addAttribute("listeAnimaux", listAnimaux);
        return  "listeAnimaux";
    }

    // Chercher animal
    @GetMapping(path = "/findAnimal")
    public String rechercheAnimal(@RequestParam(name = "filtre") String filtre, Model model){
        List<Animal> listFiltre = animalService.getListAnimauxLike(filtre);
        model.addAttribute("listeAnimaux", listFiltre);
        return  "listeAnimaux";
    }

    // Ajouter animal
    /*@PostMapping(path = "/animal")
    public String ajouterAnimal(@Validated @ModelAttribute("animal") AnimalDto animalDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return afficherFormulaireCreation(animalDto);
        }
        Animal animal = animalService.addAnimal(animalDto);
        return "redirect:/animaux";
    }*/

    @GetMapping(path = "/animal")
    public String afficherFormulaireCreation(@ModelAttribute("animal") AnimalDto animalDto, Model model){
        List<Regime> listeRegimes = new ArrayList<>(EnumSet.allOf(Regime.class));
        model.addAttribute("listeRegimes",listeRegimes);
        model.addAttribute("listeEspeces",animalService.getAllEspeces());
        return "addAnimal";
    }

    @PostMapping( path = "/animal")
    public String ajouterAnimal(@Validated @ModelAttribute("animal") AnimalDto animalDto, BindingResult bindingResult, Model model){
        rejectIfEmpty(bindingResult, "regime", "validation");
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return afficherFormulaireCreation(animalDto,model);
        }
        Animal animal = animalService.addAnimal(animalDto);
        return "redirect:/animaux";
    }

}
