package com.animoz.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Soigneur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String numero;
	private Date dateRecrutement;
	
	@ManyToOne
	@JoinTable(name = "PopulationSoigneur",
			joinColumns = @JoinColumn(name = "soigneur_id"),
			inverseJoinColumns = @JoinColumn(name = "animal_id"))

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
}