package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Atelier;
import java.util.List;
import java.util.Optional;


public interface AtelierService {
	Atelier saveAtelier(Atelier atelier);
	Optional<Atelier> getAtelierById(Long id);
	List<Atelier> getAllAteliers();
	Atelier updateAtelier(Atelier atelier);
	void deleteAtelier(Long id);
	 // Vous pouvez ajouter d'autres méthodes
}