package com.resateliers.Reservation.Ateliers.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Artisans")
public class Artisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtisanID")
    private Long artisanId;

    @Column(name = "Nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "Prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "artisan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Atelier> ateliers;

    // Constructeurs, getters et setters

    // Constructeur par défaut
    public Artisan() {
    }

    // Constructeur avec paramètres
    public Artisan(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ateliers  = new HashSet<>();
    }

    // Getters et setters
	public Long getArtisanId() {
		return artisanId;
	}

	public void setArtisanId(Long artisanId) {
		this.artisanId = artisanId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Atelier> getAteliers() {
		return ateliers;
	}

	public void setAteliers(Set<Atelier> ateliers) {
		this.ateliers = ateliers;
	}
    
}
