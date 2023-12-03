package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Creneau;
import java.util.List;
import java.util.Optional;


public interface CreneauService {
	Creneau saveCreneau(Creneau creneau);
	Optional<Creneau> getCreneauById(Long id);
	List<Creneau> getAllCreneaus();
	Creneau updateCreneau(Creneau creneau);
	void deleteCreneau(Long id);
	 // Vous pouvez ajouter d'autres méthodes
}