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
				if(hero.getPosY()!=0)
					hero.setPos(hero.getPosX(),hero.getPosY()-1);
				break;
			case "bas":  //TODO;
				if(hero.getPosY()!=map.getLargeur())
					hero.setPos(hero.getPosX(),hero.getPosY()+1);
			    break;
			case "gauche":  //TODO;
				if(hero.getPosX()!=0)
					hero.setPos(hero.getPosX()-1,hero.getPosY());
			    break;
			case "droite":  //TODO;
				if(hero.getPosX()!=map.getHauteur())
					hero.setPos(hero.getPosX()+1,hero.getPosY());
			    break;
			default: //TODO invalide direction;
			    break;
		}
	}
	
	public void afficher(){
		afficheur.afficher(this);
	}
	
}
