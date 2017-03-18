package client;

import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;

public class Jeu {
	IPersonnage hero;
	public static Map map;
	IPersonnage ennemi;
	IAfficheur afficheur;
	
	public IAfficheur getAfficheur() {
		return afficheur;
	}


	public void setAfficheur(IAfficheur afficheur) {
		this.afficheur = afficheur;
	}


	public Jeu(IPersonnage hero, Map map, IPersonnage ennemi) {
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


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		Jeu.map = map;
	}
	
	public void afficher(){
		afficheur.afficher(this);
	}
	
}
