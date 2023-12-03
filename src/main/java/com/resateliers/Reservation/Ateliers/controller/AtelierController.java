package com.resateliers.Reservation.Ateliers.controller;

import com.resateliers.Reservation.Ateliers.service.AtelierService;
//Importation pour l'injection de dépendance
import org.springframework.beans.factory.annotation.Autowired; 
//Importation pour marquer la classe comme contrôleur
import org.springframework.stereotype.Controller; 
//Importation pour passer des données à la vue
import org.springframework.ui.Model;
//Importation pour gérer les requêtes GET
import org.springframework.web.bind.annotation.GetMapping; 

@Controller // Annoter la classe comme contrôleur pour qu'elle puisse gérer les requêtes web
public class AtelierController {

	private final AtelierService atelierService; // Déclaration du service pour les ateliers
	
	@Autowired // Utilisation de l'injection de dépendance pour injecter une instance de AtelierService
	public AtelierController(AtelierService atelierService) {
	    this.atelierService = atelierService; // Affectation du service injecté au champ de la classe
	}
	
	@GetMapping("/ateliers") // Définition de la méthode pour répondre à une requête GET à 
	//l'URL "/ateliers"
	public String listAteliers(Model model) {
	    // Ajout de la liste de tous les ateliers au modèle, qui sera accessible dans la vue
	    model.addAttribute("ateliers", atelierService.getAllAteliers());
	    
	    // Retour du nom du template Thymeleaf pour afficher la liste des ateliers
	    // Le template "liste-ateliers" sera chargé et les données "ateliers" seront disponibles
	    //pour l'affichage
	    return "liste-ateliers"; 
	}
}

