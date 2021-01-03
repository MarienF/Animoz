package com.animoz.controller;

import com.animoz.model.Regime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class AnimalDto {

    @NotBlank(message = "Le nom du soigneur est obligatoire.")
    private String nom;

    private Regime regime;

    @NotBlank(message = "L'espece est obligatoire.")
    private String espece;

    private String description;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Regime getRegime() {
        return regime;
    }
    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public String getEspece() {
        return espece;
    }
    public void setEspece(String espece) {
        this.espece = espece;
    }
}
