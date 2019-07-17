package dev.controller;

import java.util.ArrayList;
import java.util.List;

import dev.entity.Collegue;
import dev.Service.CollegueService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin //permet de communiquer inter server
@RestController
@RequestMapping("/collegues")
public class CollegueController {
	CollegueService collService;
	
	public CollegueController() {
		super();
		collService=new CollegueService();
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

}
