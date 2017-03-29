package client;

import client.interfaces.IAfficheur;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
/**
 * Classe Jeu. Définit le jeu.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, VallÃ©e
 */
public class Jeu {
	IPersonnage hero;
	public static IMap map;
	IAfficheur afficheur;
	IEntreeUtilisateur entree;
	
	
	/**
	 * Accesseur de l'attribut entree de la classe Jeu
	 * 
	 * @return IEntreeUtilisateur : l'attribut entree de la classe Jeu
	 */
	public IEntreeUtilisateur getEntree() {
		return entree;
	}

	
	/**
	 * Setter de l'attribut entree de la classe Jeu
	 * 
	 * @param entree : le nouveau attribut entree.
	 */
	public void setEntree(IEntreeUtilisateur entree) {
		this.entree = entree;
	}

	
	/**
	 * Accesseur de l'attribut afficheur de la classe Jeu
	 * 
	 * @return IAfficheur : l'attribut afficheur de la classe Jeu
	 */
	public IAfficheur getAfficheur() {
		return afficheur;
	}

	/**
	 * Setter de l'attribut afficheur de la classe Jeu
	 * 
	 * @param entree : le nouveau attribut afficheur.
	 */
	public void setAfficheur(IAfficheur afficheur) {
		this.afficheur = afficheur;
	}

	/**
	 * Constructeur de la classe Jeu
	 * 
	 * @param hero : le hero du jeu.
	 * @param map : la map du jeu.
	 * @param entree : l'entree utilisateur du jeu
	 * @return Jeu : le jeu construit.
	 * @warning l'attribut afficheur n'est pas définit par le constructeur
	 */
	public Jeu(IPersonnage hero, IMap map, IEntreeUtilisateur entree) {
		super();
		this.hero = hero;
		Jeu.map = map;
		this.entree = entree;
	}
	
	
	/**
	 * Accesseur de l'attribut hero de la classe Jeu
	 * 
	 * @return IPersonnage : l'attribut hero de la classe Jeu
	 */
	public IPersonnage getHero() {
		return hero;
	}

	/**
	 * Setter de l'attribut hero de la classe Jeu
	 * 
	 * @param hero : le nouveau attribut hero.
	 */
	public void setHero(IPersonnage hero) {
		this.hero = hero;
	}

	
	/**
	 * Accesseur de l'attribut map de la classe Jeu
	 * 
	 * @return IMap : l'attribut map de la classe Jeu
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Setter de l'attribut map de la classe Jeu
	 * 
	 * @param map : le nouveau attribut map.
	 */
	public void setMap(IMap map) {
		Jeu.map = map;
	}
	
	/**
	 * Procéde à l'affichage graphique du jeu.
	 * 
	 */
	public void afficher(){
		afficheur.afficher(this);
	}
	
}
