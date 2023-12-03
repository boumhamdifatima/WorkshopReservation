package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Atelier;
import com.resateliers.Reservation.Ateliers.repository.AtelierRepository;

import jakarta.transaction.Transactional; // Importation pour la gestion des transactions.

import org.springframework.beans.factory.annotation.Autowired; // Importation pour l'injection de dépendance.
import org.springframework.stereotype.Service; // Importation pour indiquer que c'est un service Spring.

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
//dans le cadre d'une transaction.
public class AtelierServiceImpl implements AtelierService {

    private final AtelierRepository atelierRepository; // Déclaration du repository pour les Ateliers.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //AtelierRepository.
    public AtelierServiceImpl(AtelierRepository atelierRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.atelierRepository = atelierRepository; 
    }

    @Override // Implémentation de la méthode pour enregistrer un atelier.
    public Atelier saveAtelier(Atelier atelier) {
        return atelierRepository.save(atelier); // Appel du repository pour enregistrer le atelier.
    }

    @Override // Implémentation de la méthode pour obtenir un atelier par son ID.
    public Optional<Atelier> getAtelierById(Long id) {
        return atelierRepository.findById(id); // Appel du repository pour trouver le atelier.
    }

    @Override // Implémentation de la méthode pour obtenir tous les ateliers.
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll(); // Appel du repository pour obtenir tous les ateliers.
    }

    @Override // Implémentation de la méthode pour mettre à jour un Atelier.
    public Atelier updateAtelier(Atelier atelier) {
        return atelierRepository.save(atelier); // Appel du repository pour enregistrer (et donc mettre à jour) le atelier.
    }

    @Override // Implémentation de la méthode pour supprimer un atelier par son ID.
    public void deleteAtelier(Long id) {
        atelierRepository.deleteById(id); // Appel du repository pour supprimer le atelier.
    }

    // ... Vous pouvez ajouter d'autres méthodes ici si nécessaire ...

}