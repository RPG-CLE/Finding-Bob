package client;

import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;
import extension.Afficheur;

public class Jeu {
	IPersonnage hero;
	Map map;
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
		this.map = map;
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
		this.map = map;
	}

	public void deplacer(String deplacement){
		switch (deplacement) {
			case "haut":  //TODO;
				if(hero.getY()!=0)
					hero.setPos(hero.getX(),hero.getY()-1);
				break;
			case "bas":  //TODO;
				if(hero.getY()!=map.getLargeur())
					hero.setPos(hero.getX(),hero.getY()+1);
			    break;
			case "gauche":  //TODO;
				if(hero.getX()!=0)
					hero.setPos(hero.getX()-1,hero.getY());
			    break;
			case "droite":  //TODO;
				if(hero.getX()!=map.getHauteur())
					hero.setPos(hero.getX()+1,hero.getY());
			    break;
			default: //TODO invalide direction;
			    break;
		}
	}
	
	public void afficher(){
		afficheur.afficher(this);
	}
	
}
