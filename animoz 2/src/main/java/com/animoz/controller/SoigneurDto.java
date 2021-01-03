package com.animoz.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class SoigneurDto {

    @NotBlank(message = "Le nom du soigneur est obligatoire.")
    private String nom;

    @NotBlank(message = "le numéro est obligatoire.")
    private String numero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La date est obligatoire.")
    @PastOrPresent(message = "La date doit être passée.")
    private Date dateRecrutement;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateRecrutement(){
        return dateRecrutement;
    }
    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }
}
