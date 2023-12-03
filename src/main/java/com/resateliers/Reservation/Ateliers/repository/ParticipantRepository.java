package com.resateliers.Reservation.Ateliers.repository;

import com.resateliers.Reservation.Ateliers.models.Participant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

	// Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
	// Spring Data JPA implémentera les méthodes de base pour vous, 
	//comme findAll(), findById(), save(), deleteById(), etc.
		
	// Vous pouvez également définir des méthodes personnalisées :
	Optional<Participant> findByEmail(String email);
    
}

