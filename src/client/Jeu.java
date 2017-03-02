package client;

public class Jeu {
	IPersonnage hero;
	Map map;
	IPersonnage ennemi;
	
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
		int x_hero = hero.getX();
		int y_hero = hero.getY();
		int x_ennemi = ennemi.getX();
		int y_ennemi = ennemi.getY();
		for(int i = 0; i<map.getHauteur(); ++i){
			for(int j = 0; j<map.getLargeur(); ++j){
				if(x_hero==j&&y_hero==i)
					System.out.print("H");
				else if(x_ennemi==j&&y_ennemi==i&&ennemi.getPv()>0)
					System.out.print("E");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	}
	
}
