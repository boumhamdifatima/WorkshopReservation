package com.resateliers.Reservation.Ateliers.repository;

import com.resateliers.Reservation.Ateliers.models.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    // Vous pouvez ajouter des méthodes spécifiques de requête ici si nécessaire
	// Spring Data JPA implémentera les méthodes de base pour vous, 
	//comme findAll(), findById(), save(), deleteById(), etc.
		
	// Vous pouvez également définir des méthodes personnalisées, par exemple :
	//List<Atelier> findByNom(String nom);
}


