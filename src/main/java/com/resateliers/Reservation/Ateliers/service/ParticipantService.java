package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Participant;
import java.util.List;
import java.util.Optional;


public interface ParticipantService {
	Participant saveParticipant(Participant participant);
	Optional<Participant> getParticipantById(Long id);
	List<Participant> getAllParticipants();
	Participant updateParticipant(Participant participant);
	void deleteParticipant(Long id);
	 // Vous pouvez ajouter d'autres méthodes
	Optional<Participant> getParticipantByEmail(String email);
}