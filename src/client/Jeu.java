package client;

import client.interfaces.IAfficheur;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;

public class Jeu {
	IPersonnage hero;
	public static IMap map;
	IAfficheur afficheur;
	IEntreeUtilisateur entree;
	
	public IEntreeUtilisateur getEntree() {
		return entree;
	}


	public void setEntree(IEntreeUtilisateur entree) {
		this.entree = entree;
	}


	public IAfficheur getAfficheur() {
		return afficheur;
	}


	public void setAfficheur(IAfficheur afficheur) {
		this.afficheur = afficheur;
	}

	public Jeu(IPersonnage hero, IMap map, IEntreeUtilisateur entree) {
		super();
		this.hero = hero;
		Jeu.map = map;
		this.entree = entree;
	}
	
	
	public IPersonnage getHero() {
		return hero;
	}


	public void setHero(IPersonnage hero) {
		this.hero = hero;
	}


	public IMap getMap() {
		return map;
	}


	public void setMap(IMap map) {
		Jeu.map = map;
	}
	
	public void afficher(){
		afficheur.afficher(this);
	}
	
}
