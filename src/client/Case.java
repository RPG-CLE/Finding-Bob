package client;

import client.interfaces.IPersonnage;

/**
 * Classe Case. Définit les cases de la maap.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, VallÃ©e
 *
 */


public class Case{
	String nom;
	int action;
	IPersonnage personnage = null;
	/**
	 * Constructeur de la classe Case
	 * 
	 * @param caseType : string qui définit le type de la case (attribut nom)
	 * @return Case : la case construite avec l'attribut nom = caseType, l'attribut action non
	 * initialisé et l'attribut personage = null
	 */
	public Case(String caseType) {
		this.nom = caseType;
	}
	/**
	 * Accesseur de l'attribut nom de la classe Case
	 * 
	 * @return String : le nom de la case
	 * @warning le nom définit le type de la case
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter de l'attribut nom de la classe Case
	 * 
	 * @param nom : le nouveau nom de la case
	 * @warning le nom définit le type de la case
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Accesseur de l'attribut action de la classe Case
	 * 
	 * @return int : l'action de la case
	 */
	public int getAction() {
		return action;
	}
	/**
	 * Setter de l'attribut action de la classe Case
	 * 
	 * @param action : la nouvelle action de la case
	 */
	public void setAction(int action) {
		this.action = action;
	}
	/**
	 * Accesseur de l'attribut personnage de la classe Case
	 * 
	 * @return IPersonnage : le personnage  de la case
	 */
	public IPersonnage getPersonnage() {
		return personnage;
	}
	/**
	 * Setter de l'attribut personnage de la classe Case
	 * 
	 * @param personnage : le nouveau personnage de la case
	 */
	public void setPersonnage(IPersonnage personnage) {
		this.personnage = personnage;
	}
	
	
	
}
