package client;

import client.interfaces.IAfficheur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;

public class Jeu {
	IPersonnage hero;
	public static IMap map;
	IPersonnage ennemi;
	IAfficheur afficheur;
	
	public IAfficheur getAfficheur() {
		return afficheur;
	}


	public void setAfficheur(IAfficheur afficheur) {
		this.afficheur = afficheur;
	}


	public Jeu(IPersonnage hero, IMap map, IPersonnage ennemi) {
		super();
		this.hero = hero;
		Jeu.map = map;
		this.ennemi = ennemi;
	}
	
	
	public IPersonnage getHero() {
		return hero;
	}


	public void setHero(IPersonnage hero) {
		this.hero = hero;
	}

	public IPersonnage getEnnemi() {
		return this.ennemi;
	}


	public void setEnnemi(IPersonnage vilain) {
		this.ennemi = vilain;
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
