package com.resateliers.Reservation.Ateliers.service;

import com.resateliers.Reservation.Ateliers.models.Participant;
import com.resateliers.Reservation.Ateliers.repository.ParticipantRepository;

import jakarta.transaction.Transactional; // Importation pour la gestion des transactions.

import org.springframework.beans.factory.annotation.Autowired; // Importation pour l'injection de dépendance.
import org.springframework.stereotype.Service; // Importation pour indiquer que c'est un service Spring.

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
//dans le cadre d'une transaction.
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository; // Déclaration du repository pour les Participants.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //ParticipantRepository.
    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.participantRepository = participantRepository; 
    }

    @Override // Implémentation de la méthode pour enregistrer un participant.
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant); // Appel du repository pour enregistrer le participant.
    }

    @Override // Implémentation de la méthode pour obtenir un participant par son ID.
    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id); // Appel du repository pour trouver le participant.
    }

    @Override // Implémentation de la méthode pour obtenir tous les participants.
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll(); // Appel du repository pour obtenir tous les participants.
    }

    @Override // Implémentation de la méthode pour mettre à jour un Participant.
    public Participant updateParticipant(Participant participant) {
        return participantRepository.save(participant); // Appel du repository pour enregistrer (et donc mettre à jour) le participant.
    }

    @Override // Implémentation de la méthode pour supprimer un participant par son ID.
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id); // Appel du repository pour supprimer le participant.
    }

	@Override
	public Optional<Participant> getParticipantByEmail(String email) {
		
		return participantRepository.findByEmail(email);
	}

    // ... Vous pouvez ajouter d'autres méthodes ici si nécessaire ...

}