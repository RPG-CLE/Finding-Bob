package client;

import client.interfaces.IPersonnage;

public class Case{
	String nom;
	int action;
	IPersonnage personnage;
	
	public Case(String caseType) {
		this.nom = caseType;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public IPersonnage getPersonnage() {
		return personnage;
	}
	public void setPersonnage(IPersonnage personnage) {
		this.personnage = personnage;
	}
	
	
	
}
