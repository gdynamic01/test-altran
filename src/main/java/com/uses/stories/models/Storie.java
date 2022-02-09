package com.uses.stories.models;

/**
 * 
 * @author Mamadou
 *
 * Modeles de données remonté
 */
public class Storie {
	
	private int idStorie; // identifiant du uses story
	private String title;
	private EtatEnum etatEnum;
	private String description;
	
	// cette variable peut referencer un objet user (qui pourra etre representé comme clé étrangère dans la BDD)
	private String identifiant;
	
	public Storie(int idStories, String title, EtatEnum etatEnum, String description, String identifiant) {
	    this.idStorie = idStories;
		this.title = title;
	    this.etatEnum = etatEnum;
	    this.description = description;
	    this.identifiant = identifiant;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public EtatEnum getEtatEnum() {
		return etatEnum;
	}
	public void setEtatEnum(EtatEnum etatEnum) {
		this.etatEnum = etatEnum;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdStories() {
		return idStorie;
	}

	public void setIdStories(int idStories) {
		this.idStorie = idStories;
	}
}
