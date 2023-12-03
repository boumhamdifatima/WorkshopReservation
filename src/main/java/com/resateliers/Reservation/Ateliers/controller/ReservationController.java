package com.resateliers.Reservation.Ateliers.controller;

import com.resateliers.Reservation.Ateliers.service.ParticipantService;
import com.resateliers.Reservation.Ateliers.service.AtelierService;
import com.resateliers.Reservation.Ateliers.service.ReservationService;
import com.resateliers.Reservation.Ateliers.service.CreneauService;
import com.resateliers.Reservation.Ateliers.models.*;

import java.util.Optional;

//Importation pour l'injection de dépendance
import org.springframework.beans.factory.annotation.Autowired; 
//Importation pour marquer la classe comme contrôleur
import org.springframework.stereotype.Controller; 
//Importation pour passer des données à la vue
import org.springframework.ui.Model;
//Importation pour gérer les requêtes GET
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // Annoter la classe comme contrôleur pour qu'elle puisse gérer les requêtes web
public class ReservationController {
	
	private final AtelierService atelierService; // Déclaration du service pour les ateliers
	private final ParticipantService participantService; // Déclaration du service pour les participants
	private final ReservationService reservationService; // Déclaration du service pour les participants
	private final CreneauService creneauService;
	
	@Autowired // Utilisation de l'injection de dépendance pour injecter une instance de AtelierService
	public ReservationController(AtelierService atelierService, ParticipantService participantService,
			ReservationService reservationService, CreneauService creneauService) {
	    this.atelierService = atelierService; // Affectation du service injecté au champ de la classe
	    this.participantService = participantService;
	    this.reservationService = reservationService;
	    this.creneauService = creneauService;
	}
	
	
	@GetMapping("/reserverAtelier")
	public String afficherFormulaireReservation(@RequestParam Long atelierId,
	        @RequestParam Long creneauId,
	        Model model) {
	    // Récupérer les informations nécessaires au modèle (atelier et creneau)
	    Optional<Atelier> atelier = atelierService.getAtelierById(atelierId);
	    Optional<Creneau> creneau = creneauService.getCreneauById(creneauId);

	    model.addAttribute("atelier", atelier);
	    model.addAttribute("creneau", creneau);
	    model.addAttribute("participant", new Participant());

	    return "reserver-atelier";
	}
	
	@PostMapping("/reserverAtelier")
	public String creerReservation(@RequestParam Long creneauId,
	                               @ModelAttribute("participant") Participant participant,
	                               Model model) {
	    
	    try {
	        
	    	// Décrémenter le nombre de places disponibles du créneau
	    	Creneau creneau = creneauService.getCreneauById(creneauId).orElseThrow(() -> new RuntimeException("Le créneau n'existe pas"));
	        
	        int placesDisponibles = creneau.getPlacesDisponibles();
	        if (placesDisponibles > 0) {
	            creneau.setPlacesDisponibles(placesDisponibles - 1);
	            creneauService.saveCreneau(creneau);
	        } else {
	            // Gérer le cas où il n'y a plus de places disponibles
	            model.addAttribute("error", "Il n'y a plus de places disponibles pour ce créneau.");
	            
	            return "erreur";
	            
	        }
	        
	        // Vérifier si le participant existe par e-mail
	        Optional<Participant> existingParticipant = participantService.getParticipantByEmail(participant.getEmail());

	        
	        if (existingParticipant.isPresent()) {
	            // Le participant existe, utilisez les informations existantes
	            participant = existingParticipant.get();
	        } else {
	            // Le participant n'existe pas, sauvegardez le nouveau participant
	            participantService.saveParticipant(participant);
	        }

	        // Créer une nouvelle réservation
	        Reservation reservation = new Reservation();
	        reservation.setParticipant(participant);
	        reservation.setCreneau(creneau);

	        // Enregistrer la réservation
	        reservationService.saveReservation(reservation);
	        
	        

	        // Ajouter le reservationId comme attribut dans le modèle
	        model.addAttribute("reservationId", reservation.getReservationId());

	        // Rediriger vers la page de confirmation
	        return "confirmation-reservation";
	        
	    } catch (Exception e) {
	        // Gérer l'erreur et rediriger vers une page d'erreur
	        model.addAttribute("error", "Une erreur s'est produite lors de la réservation.");
	        return "erreur";
	    }
	}

	
	
	@GetMapping("/erreur")
    public String erreur() {
        return "erreur";
    }
	
	@GetMapping("/reservations") // Définition de la méthode pour répondre à une requête GET à 
	//l'URL "/reservatons"
	public String listReservations(Model model) {
	    // Ajout de la liste de toutes les reservations au modèle, qui sera accessible dans la vue
	    model.addAttribute("reservations", reservationService.getAllReservations());
	    
	    // Retour du nom du template Thymeleaf pour afficher la liste des reservations
	    // Le template "liste-reservations" sera chargé et les données "reservations" seront disponibles
	    //pour l'affichage
	    return "liste-reservations"; 
	}
	
	@PostMapping("/annulerReservation")
	public String annulerReservation(@RequestParam Long reservationId, Model model) {
	    try {
	        // Récupérer la réservation à annuler
	        Reservation reservation = reservationService.getReservationById(reservationId)
	                .orElseThrow(() -> new RuntimeException("La réservation n'existe pas"));

	        // Récupérer le créneau associé à la réservation
	        Creneau creneau = reservation.getCreneau();

	        // Incrémenter le nombre de places disponibles du créneau
	        creneau.setPlacesDisponibles(creneau.getPlacesDisponibles() + 1);
	        creneauService.saveCreneau(creneau);

	        // Supprimer la réservation
	        reservationService.deleteReservation(reservationId);

	        // Rediriger vers la page de liste des réservations mise à jour
	        return "redirect:/reservations";
	    } catch (Exception e) {
	        // Gérer l'erreur et rediriger vers une page d'erreur
	        model.addAttribute("error", "Une erreur s'est produite lors de l'annulation de la réservation.");
	        return "redirect:/erreur";
	    }
	}


}


    