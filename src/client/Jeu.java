package client;

import client.interfaces.IAfficheur;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
/**
 * Classe Jeu. Définit le jeu.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 */
public class Jeu {
	IPersonnage heros;
	public static IMap map;
	IAfficheur afficheur;
	IEntreeUtilisateur entree;
	boolean gameOn;
	
	
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
	 * @param heros : le heros du jeu.
	 * @param map : la map du jeu.
	 * @param entree : l'entree utilisateur du jeu
	 * @return Jeu : le jeu construit.
	 * @warning l'attribut afficheur n'est pas d�finit par le constructeur
	 */
	public Jeu(IPersonnage heros, IMap map, IEntreeUtilisateur entree) {
		super();
		this.heros = heros;
		Jeu.map = map;
		this.entree = entree;
		this.gameOn = true;
	}
	
	
	/**
	 * Accesseur de l'attribut heros de la classe Jeu
	 * 
	 * @return IPersonnage : l'attribut heros de la classe Jeu
	 */
	public IPersonnage getHeros() {
		return heros;
	}

	/**
	 * Setter de l'attribut heros de la classe Jeu
	 * 
	 * @param heros : le nouveau attribut heros.
	 */
	public void setHeros(IPersonnage heros) {
		this.heros = heros;
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
	 * Proc�de � l'affichage graphique du jeu.
	 * 
	 */
	public void afficher(){
		afficheur.afficher(this);
	}
	
	/**
	 * Accesseur de l'attribut gameOn de la classe Jeu
	 * 
	 * @return gameOn : l'attribut gameOn de la classe Jeu
	 */
	public boolean getGameOn() {
		return gameOn;
	}
	
	/**
	 * Setter de l'attribut gameOn de la classe Jeu
	 * 
	 * @param gameOn : l'attribut gameOn de la classe Jeu
	 */
	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
}
