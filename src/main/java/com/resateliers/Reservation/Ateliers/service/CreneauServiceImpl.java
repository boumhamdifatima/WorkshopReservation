package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Creneau;
import com.resateliers.Reservation.Ateliers.repository.CreneauRepository;

import jakarta.transaction.Transactional; // Importation pour la gestion des transactions.

import org.springframework.beans.factory.annotation.Autowired; // Importation pour l'injection de dépendance.
import org.springframework.stereotype.Service; // Importation pour indiquer que c'est un service Spring.

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
//dans le cadre d'une transaction.
public class CreneauServiceImpl implements CreneauService {

    private final CreneauRepository creneauRepository; // Déclaration du repository pour les Creneaux.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //CreneauRepository.
    public CreneauServiceImpl(CreneauRepository creneauRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.creneauRepository = creneauRepository; 
    }

    @Override // Implémentation de la méthode pour enregistrer un creneau.
    public Creneau saveCreneau(Creneau creneau) {
        return creneauRepository.save(creneau); // Appel du repository pour enregistrer le creneau.
    }

    @Override // Implémentation de la méthode pour obtenir un creneau par son ID.
    public Optional<Creneau> getCreneauById(Long id) {
        return creneauRepository.findById(id); // Appel du repository pour trouver le creneau.
    }

    @Override // Implémentation de la méthode pour obtenir tous les creneaux.
    public List<Creneau> getAllCreneaus() {
        return creneauRepository.findAll(); // Appel du repository pour obtenir tous les creneaux.
    }

    @Override // Implémentation de la méthode pour mettre à jour un Creneau.
    public Creneau updateCreneau(Creneau creneau) {
        return creneauRepository.save(creneau); // Appel du repository pour enregistrer (et donc mettre à jour) le creneau.
    }

    @Override // Implémentation de la méthode pour supprimer un creneau par son ID.
    public void deleteCreneau(Long id) {
        creneauRepository.deleteById(id); // Appel du repository pour supprimer le creneau.
    }

    // ... Vous pouvez ajouter d'autres méthodes ici si nécessaire ...


}
