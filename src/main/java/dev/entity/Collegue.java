package dev.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Collegue {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String matricule;
	protected String nom;
	protected String prenoms;
	protected String email;
	protected LocalDate ddn;
	protected String photoUrl;

	public Collegue() {
	}

	public Collegue(Integer id, String matricule, String nom, String prenoms, String email, LocalDate ddn, String photoUrl) {
		this.id= id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenoms = prenoms;
		this.email = email;
		this.ddn = ddn;
		this.photoUrl = photoUrl;
	}

	public Collegue(String matricule, String nom, String prenoms, String email, LocalDate ddn, String photoUrl) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenoms = prenoms;
		this.email = email;
		this.ddn = ddn;
		this.photoUrl = photoUrl;
	}
	
    
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDdn() {
		return ddn;
	}
	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Collegue [matricule=");
		builder.append(matricule);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenoms=");
		builder.append(prenoms);
		builder.append(", email=");
		builder.append(email);
		builder.append(", ddn=");
		builder.append(ddn);
		builder.append(", photoUrl=");
		builder.append(photoUrl);
		builder.append("]");
		return builder.toString();
	}

	
	
}
