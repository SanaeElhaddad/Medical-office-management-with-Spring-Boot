package com.ProjetCabinet.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

//import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
public class Consultation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;
    
    @NotNull(message = "La date de consultation ne peut pas être nulle.")
    @FutureOrPresent(message = "La date de consultation doit être aujourd'hui ou dans le futur.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_heure_rendez_vous")
    private Date dateConsultation;
    
    @NotBlank(message = "La description ne peut pas être vide.")
    @Column(name = "description")
    private String description;
    
    @NotNull(message = "Le prix ne peut pas être nul.")
    @Min(value = 0, message = "Le prix ne peut pas être négatif.")
    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "malade_id")
    private Malade malade;

	public Consultation() {
		super();
	}

	

	public Consultation(Long idConsultation, Date dateConsultation, String description, double prix, Medecin medecin,
			Malade malade) {
		super();
		this.idConsultation = idConsultation;
		this.dateConsultation = dateConsultation;
		this.description = description;
		this.prix = prix;
		this.medecin = medecin;
		this.malade = malade;
	}



	public Long getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Malade getMalade() {
		return malade;
	}

	public void setMalade(Malade malade) {
		this.malade = malade;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
