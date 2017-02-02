package client;

public class Jeu {
	Personnage hero;
	Map map;

	public Jeu(Personnage hero, Map map) {
		super();
		this.hero = hero;
		this.map = map;
	}
	
	
	public Personnage getHero() {
		return hero;
	}


	public void setHero(Personnage hero) {
		this.hero = hero;
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
		for(int i = 0; i<map.getHauteur()+1; ++i){
			for(int j = 0; j<map.getLargeur()+1; ++j){
				if(x_hero==j&&y_hero==i)
					System.out.print("H");
				else
					System.out.print("o");
			}
			System.out.println();
		}
	}
	
}
