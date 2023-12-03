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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "ateliers")
public class Atelier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AtelierID")
    private Long atelierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArtisanID", nullable = false)
    private Artisan artisan;

    @Column(name = "Nom", nullable = false, length = 30)
    private String nom;

    @Column(name = "Description", columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "atelier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Creneau> creneaux;

    // Constructeurs, getters et setters
    public Atelier() {
	}

	public Atelier(String nom, String description) {
		this.nom = nom;
		this.description = description;
		this.creneaux = new HashSet<>();
	}

	public Long getAtelierId() {
		return atelierId;
	}

	public void setAtelierId(Long atelierId) {
		this.atelierId = atelierId;
	}

	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

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

	public Set<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Set<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
    
    
 }
