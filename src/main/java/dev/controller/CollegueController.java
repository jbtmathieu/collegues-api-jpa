package dev.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.entity.Collegue;
import dev.exception.CollegueInvalidException;
import dev.exception.CollegueNontrouveException;
import dev.Service.CollegueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin //permet de communiquer inter server
@RestController
@RequestMapping("/collegues")
public class CollegueController {
    @Autowired
	CollegueService collService;
	
	public CollegueController() {
		super();
		
	}

	@RequestMapping(
			method=RequestMethod.GET,
			params= "name")
	public List<String> RecupParamRequete(@RequestParam String name) {
		List<Collegue> collegues=collService.rechercherParNom(name);
		List<String>  response= new ArrayList<String>();
		for (int i=0; i < collegues.size();i++) {
			response.add(collegues.get(i).getMatricule());
		}
		
		return response;

	}
	
	@RequestMapping(
			method=RequestMethod.GET,
			params= "matricule")
	public Collegue ChercheMatricule(@RequestParam String matricule) {
	    Collegue collegue=null;
        collegue = collService.rechercherParMatricule(matricule);
	    return collegue;
	}
	
	@RequestMapping(
            method=RequestMethod.POST)
    public Collegue AjouterCollegue(@RequestBody Collegue collegue){
        return collService.ajouterUnCollegue(collegue);

    }
	
	@RequestMapping(
            method=RequestMethod.GET,
            params= "namefull")
    public List<Collegue> RecupCollegueRequete(@RequestParam String namefull) {
        List<Collegue> collegues=collService.rechercherParNom(namefull);
        List<Collegue>  response= new ArrayList<Collegue>();
        for (int i=0; i < collegues.size();i++) {
            response.add(collegues.get(i));
        }
        
        return response;

    }
	
	@RequestMapping(
	        value = "/photos",
            method=RequestMethod.GET
            )
    public Map<String, String> RecupPhotoMatricule() {
        Map<String, String> mapMatriculePhoto= new HashMap<>();
        List<Collegue> collegues=collService.rechercherParNom("MARTIN");
        for (int i=0; i < collegues.size();i++) {
            mapMatriculePhoto.put(collegues.get(i).getMatricule(), collegues.get(i).getPhotoUrl());
        }
        
        return mapMatriculePhoto;

    }
	

	    @RequestMapping(method = RequestMethod.PATCH, path = "/{matricule}")
	    public Collegue modifierCollegue(@PathVariable String matricule, @RequestBody Collegue collegue) {

	        if (collegue.getEmail() != null && !collegue.getEmail().isEmpty())
	            return collService.modifierEmail(matricule, collegue.getEmail());

	        if (collegue.getPhotoUrl() != null && !collegue.getPhotoUrl().isEmpty())
	            return collService.modifierPhotoUrl(matricule, collegue.getPhotoUrl());

	        return null;
	    }
    }



