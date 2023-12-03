package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Reservation;
import com.resateliers.Reservation.Ateliers.repository.ReservationRepository;

import jakarta.transaction.Transactional; // Importation pour la gestion des transactions.

import org.springframework.beans.factory.annotation.Autowired; // Importation pour l'injection de dépendance.
import org.springframework.stereotype.Service; // Importation pour indiquer que c'est un service Spring.

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
//dans le cadre d'une transaction.
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository; // Déclaration du repository pour les reservations.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //ReservationRepository.
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.reservationRepository = reservationRepository; 
    }

    @Override // Implémentation de la méthode pour enregistrer un reservation.
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation); // Appel du repository pour enregistrer la reservation.
    }

    @Override // Implémentation de la méthode pour obtenir un reservation par son ID.
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id); // Appel du repository pour trouver la reservation.
    }

    @Override // Implémentation de la méthode pour obtenir tous les reservations.
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll(); // Appel du repository pour obtenir tous les reservations.
    }

    @Override // Implémentation de la méthode pour mettre à jour une Reservation.
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation); // Appel du repository pour enregistrer (et donc mettre à jour) la reservation.
    }

    @Override // Implémentation de la méthode pour supprimer une reservation par son ID.
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id); // Appel du repository pour supprimer la reservation.
    }

    // ... Vous pouvez ajouter d'autres méthodes ici si nécessaire ...

}