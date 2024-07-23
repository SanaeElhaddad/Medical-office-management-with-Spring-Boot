package com.ProjetCabinet.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Medecin {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idMedecin;
	    
	  	@NotBlank(message = "Nom is required")
	    @Size(max = 20, message = "Nom should not exceed 20 characters")
	    @Column(name = "nom")
	    private String nom;

	    @NotBlank(message = "Prenom is required")
	    @Size(max = 20, message = "Prenom should not exceed 20 characters")
	    @Column(name = "prenom")
	    private String prenom;

	    @NotBlank(message = "Specialite is required")
	    @Size(max = 20, message = "Specialite should not exceed 25 characters")
	    @Column(name = "specialite")
	    private String specialite;

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
	    
	    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Consultation> consultation;

		public Medecin(Long idMedecin, String nom, String prenom, String specialite, String adresse,
				String numeroTelephone, String email, List<Consultation> consultation) {
			super();
			this.idMedecin = idMedecin;
			this.nom = nom;
			this.prenom = prenom;
			this.specialite = specialite;
			this.adresse = adresse;
			this.numeroTelephone = numeroTelephone;
			this.email = email;
			this.consultation = consultation;
		}

		public Medecin() {
			super();
		}

		public Long getIdMedecin() {
			return idMedecin;
		}

		public void setIdMedecin(Long idMedecin) {
			this.idMedecin = idMedecin;
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

		public String getSpecialite() {
			return specialite;
		}

		public void setSpecialite(String specialite) {
			this.specialite = specialite;
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

		public List<Consultation> getConsultation() {
			return consultation;
		}

		public void setConsultation(List<Consultation> consultation) {
			this.consultation = consultation;
		}
        
	    

}
