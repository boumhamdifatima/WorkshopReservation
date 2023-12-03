package com.resateliers.Reservation.Ateliers.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import java.time.ZonedDateTime;

@Entity
@Table(name = "creneaux")
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creneauid")
    private Long creneauId;

    @Column(name = "date_debut")
    private ZonedDateTime dateDebut;

    @Column(name = "date_fin")
    private ZonedDateTime dateFin;

    @Column(name = "places_disponibles", nullable = false, columnDefinition = "int default 0")
    private int placesDisponibles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atelierid", nullable = false)
    private Atelier atelier;

    // Constructeurs, getters et setters
    public Creneau() {
    }

    public Creneau(Long creneauId, ZonedDateTime dateDebut, ZonedDateTime dateFin, int placesDisponibles) {
        this.creneauId = creneauId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.placesDisponibles = placesDisponibles;
    }

    public Long getCreneauId() {
        return creneauId;
    }

    public void setCreneauId(Long creneauId) {
        this.creneauId = creneauId;
    }

    public ZonedDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(ZonedDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public ZonedDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(ZonedDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }
}
