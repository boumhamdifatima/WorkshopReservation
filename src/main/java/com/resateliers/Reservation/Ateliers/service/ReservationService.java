package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Reservation;
import java.util.List;
import java.util.Optional;


public interface ReservationService {
	Reservation saveReservation(Reservation reservation);
	Optional<Reservation> getReservationById(Long id);
	List<Reservation> getAllReservations();
	Reservation updateReservation(Reservation reservation);
	void deleteReservation(Long id);
	 // Vous pouvez ajouter d'autres méthodes
}