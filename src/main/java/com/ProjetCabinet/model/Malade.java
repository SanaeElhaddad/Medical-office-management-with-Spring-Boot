package com.ProjetCabinet.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Malade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMalade;

    @NotBlank(message = "Nom is required")
    @Size(max = 20, message = "Nom should not exceed 20 characters")
    @Column(name = "nom")
    private String nom;

    @NotBlank(message = "Prenom is required")
    @Size(max = 20, message = "Prenom should not exceed 20 characters")
    @Column(name = "prenom")
    private String prenom;

    @NotBlank(message = "Adresse is required")
    @Size(max = 30, message = "Adresse should not exceed 30 characters")
    @Column(name = "adresse")
    private String adresse;

    @NotBlank(message = "Numero de telephone is required")
    @Pattern(regexp = "[0-9]+", message = "Invalid phone number format")
    @Size(min = 10, message = "Numero de telephone should not less than  10 numbers")
    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email should not exceed 255 characters")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Date de naissance is required")
    @Past(message = "Date de naissance must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_naissance")
    private Date dateNaissance;

    
    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "malade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> consultation;

	public Malade() {
		super();
	}

	public Malade(Long idMalade, String nom, String prenom, String adresse, String numeroTelephone, String email,
			Date dateNaissance, String genre, List<Consultation> consultation) {
		super();
		this.idMalade = idMalade;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.genre = genre;
		this.consultation = consultation;
	}

	public Long getIdMalade() {
		return idMalade;
	}

	public void setIdMalade(Long idMalade) {
		this.idMalade = idMalade;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<Consultation> getConsultation() {
		return consultation;
	}

	public void setConsultation(List<Consultation> consultation) {
		this.consultation = consultation;
	}

    


}
