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
@Table(name = "participants")
public class Participant {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParticipantID")
    private Long participantId;

    @Column(name = "Nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "Prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "NoTel", nullable = false, length = 15)
    private String noTel;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    
    // Constructeurs, getters et setters
    public Participant() {
	}


	public Participant(Long participantId, String nom, String prenom, String noTel, String email) {
		this.participantId = participantId;
		this.nom = nom;
		this.prenom = prenom;
		this.noTel = noTel;
		this.email = email;
		this.reservations = new HashSet<>();
	}


	public Long getParticipantId() {
		return participantId;
	}


	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
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


	public String getNoTel() {
		return noTel;
	}


	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
}
