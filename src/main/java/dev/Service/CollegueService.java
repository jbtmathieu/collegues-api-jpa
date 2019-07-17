package dev.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dev.entity.Collegue;
import dev.exception.CollegueInvalidException;
import dev.exception.CollegueNontrouveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegueService {

	    private static final int AGE_MIN = 18;
        private Map<String, Collegue> data = new HashMap<>();

		@Autowired
        private CollegueRepository collegueRepository;

	    public CollegueService() {

	    	Collegue coll;
	    	String ID;
	    	ID = UUID.randomUUID().toString();
	    	coll=new Collegue(UUID.randomUUID().toString(),"RAY","Jean","jean@greatcorp.com",
	    			LocalDate.now(),"http://my/great/path.png");
	        data.put(ID, coll);
	      
	        coll=new Collegue("123","RAY","Jacques","jacques@greatcorp.com",
	    			LocalDate.now(),"http://my/great/path.png");
	        data.put("123", coll);
	        
	        ID = UUID.randomUUID().toString();
	        coll=new Collegue(ID,"SMITH","Pierre","pierre@greatcorp.com",
	    			LocalDate.now(),"http://my/great/path.png");
	        data.put(ID, coll);
	        
	        ID = UUID.randomUUID().toString();
	        coll=new Collegue(ID,"RAY","John","john@greatcorp.com",
	    			LocalDate.now(),"http://my/great/path.png");
	        data.put(ID, coll);
	        
	        ID = UUID.randomUUID().toString();
	        coll=new Collegue(ID,"MARTIN","William","will@greatcorp.com",
	    			LocalDate.now(),"http://my/great/path.png");
	        data.put(ID, coll);
	        
	        data.put(UUID.randomUUID().toString(), new Collegue(ID,"MARTIN","Yves","my@greatcorp.com",
                    LocalDate.now(),"http://my/great/my.png"));
	        data.put(UUID.randomUUID().toString(), new Collegue(ID,"MAHRT","John","mj@greatcorp.com",
                    LocalDate.now(),"http://my/great/mj.png"));
	        data.put(UUID.randomUUID().toString(), new Collegue(ID,"MARTTY","Jack","mj@greatcorp.com",
                    LocalDate.now(),"http://my/great/mj.png"));
	        data.put(UUID.randomUUID().toString(), new Collegue(ID,"MARTIN","Pierre","mp@greatcorp.com",
                    LocalDate.now(),"http://my/great/mp.png"));
            data.put(UUID.randomUUID().toString(), new Collegue(ID,"MARSOUIN","John","mj@greatcorp.com",
                    LocalDate.now(),"http://my/greatmj.png"));
            data.put(UUID.randomUUID().toString(), new Collegue(ID,"MARIN","Gilles","mg@greatcorp.com",
                    LocalDate.now(),"http://my/great/mg.png"));

	    }
	    
	    
	    public List<Collegue> rechercherParNom(String nomRecherche) {
	        // TODO retourner une liste de collègues dont le nom est fourni
	    	

	    	List<Collegue> collegues = new ArrayList<Collegue>();
	    	if ( nomRecherche != null) {
	    	data.forEach((id, coll) -> {
				if(coll.getNom().equals(nomRecherche)) {
					collegues.add(coll);
				}
			});
	    	}
	    	return collegues;
	    	
	    }

	    public Collegue rechercherParMatricule(String matriculeRecherche) {
	    	
	    	if ( matriculeRecherche != null) {
	    	
	    	Collegue colle = null;
	    	for (Map.Entry<String, Collegue> entry : data.entrySet()) { 
	            if (entry.getValue().getMatricule().equals(matriculeRecherche)) {
	            	colle=entry.getValue();
	            	return colle;
	            }
	    		}
	    	if (colle==null) {
                        throw new CollegueNontrouveException("Matricule non trouvé");
	    	}
	    	}
	    	return null;
	    	
	    }
	    public Collegue ajouterUnCollegue(Collegue collegueAAjouter) {

	    	if (collegueAAjouter != null) {
	    		// TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
	    		if (collegueAAjouter.getNom().length() > 2 &&
	    			collegueAAjouter.getPrenoms().length() > 2) {
	    			// TODO Vérifier que l'email a au moins 3 caractères et contient `@`
	    			if (collegueAAjouter.getEmail().length() >=3 &&
	    				collegueAAjouter.getEmail().contains("@")) {
	    				// TODO Vérifier que la photoUrl commence bien par `http`
	    				if (collegueAAjouter.getPhotoUrl().startsWith("http")) {
	    					// TODO Vérifier que la date de naissance correspond à un age >= 18
	    					if(Period.between(collegueAAjouter.getDdn(), LocalDate.now()).getYears() 
	    							>= AGE_MIN) {
	    						
	    						// TODO générer un matricule pour ce collègue (`UUID.randomUUID().toString()`)
	    						collegueAAjouter.setMatricule(UUID.randomUUID().toString());
	    				        // TODO Sauvegarder le collègue
	    						data.put(collegueAAjouter.getMatricule(), collegueAAjouter);
	    						//System.out.println(data.size());
	    						
	    						return collegueAAjouter;
	    						
	    					} else throw new CollegueInvalidException("Not Legal Aged.");
	    				}else throw new CollegueInvalidException("PhotoPath Invalid.");
	    			}else throw new CollegueInvalidException("Email Invalid.");
	    		}else throw new CollegueInvalidException("Name and FirstName too short.");	    		
	    	}else throw new CollegueInvalidException("No Data");   
	    	
	    	// TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
	        // `CollegueInvalideException`.
	    }
	    
	    
	    public Collegue modifierEmail(String matricule, String email) {

	        Collegue collegue = rechercherParMatricule(matricule);

	         // TODO retourner une exception `CollegueNonTrouveException`
	         //  si le matricule ne correspond à aucun collègue

	        if (email.length() >=3 && email.contains("@")) {
	        
	         // TODO Modifier le collègue
	            collegue.setEmail(email);
	            
	            return collegue;
	            
	         // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
	            // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
	            // `CollegueInvalideException`. avec un message approprié.
	        }else throw new CollegueInvalidException("Email Invalid."); 
	    }


	    public Collegue modifierPhotoUrl(String matricule, String photoUrl) {
	        
	        Collegue collegue = rechercherParMatricule(matricule);
	         // TODO retourner une exception `CollegueNonTrouveException`
	         //  si le matricule ne correspond à aucun collègue

	        if (photoUrl.startsWith("http")) {
	            
	             // TODO Modifier le collègue
	                collegue.setPhotoUrl(photoUrl);
	                
	                return collegue;
	                
	                // TODO Vérifier que la photoUrl commence bien par `http`
	                // TODO Si la règle ci-dessus n'est pas valide, générer une exception :
	                // `CollegueInvalideException`. avec un message approprié.
	            }else throw new CollegueInvalidException("PhotoPath Invalid."); 
	        
	
	        // TODO Modifier le collègue
	    }
	    
}
