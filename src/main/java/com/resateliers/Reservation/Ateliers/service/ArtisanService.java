package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Artisan;
import java.util.List;
import java.util.Optional;


public interface ArtisanService {
	Artisan saveArtisan(Artisan artisan);
	Optional<Artisan> getArtisanById(Long id);
	List<Artisan> getAllArtisans();
	Artisan updateArtisan(Artisan artisan);
	void deleteArtisan(Long id);
	 // Vous pouvez ajouter d'autres méthodes
}

