package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Artisan;
import com.resateliers.Reservation.Ateliers.repository.ArtisanRepository;

import jakarta.transaction.Transactional; // Importation pour la gestion des transactions.

import org.springframework.beans.factory.annotation.Autowired; // Importation pour l'injection de dépendance.
import org.springframework.stereotype.Service; // Importation pour indiquer que c'est un service Spring.

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
//dans le cadre d'une transaction.
public class ArtisanServiceImpl implements ArtisanService {

    private final ArtisanRepository artisanRepository; // Déclaration du repository pour les Artisans.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //ArtisanRepository.
    public ArtisanServiceImpl(ArtisanRepository artisanRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.artisanRepository = artisanRepository; 
    }

    @Override // Implémentation de la méthode pour enregistrer un artisan.
    public Artisan saveArtisan(Artisan artisan) {
        return artisanRepository.save(artisan); // Appel du repository pour enregistrer le artisan.
    }

    @Override // Implémentation de la méthode pour obtenir un artisan par son ID.
    public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id); // Appel du repository pour trouver le artisan.
    }

    @Override // Implémentation de la méthode pour obtenir tous les artisans.
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll(); // Appel du repository pour obtenir tous les artisans.
    }

    @Override // Implémentation de la méthode pour mettre à jour un Artisan.
    public Artisan updateArtisan(Artisan artisan) {
        return artisanRepository.save(artisan); // Appel du repository pour enregistrer (et donc mettre à jour) le artisan.
    }

    @Override // Implémentation de la méthode pour supprimer un artisan par son ID.
    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id); // Appel du repository pour supprimer le artisan.
    }

    // ... Vous pouvez ajouter d'autres méthodes ici si nécessaire ...

}