package extension;

import client.Jeu;
import client.interfaces.IAfficheur;

public class Afficheur implements IAfficheur{
	
	public Afficheur(){}
	/* (non-Javadoc)
	 * @see extension.IAfficheur#afficher(client.Jeu)
	 */
	@Override
	public void afficher(Jeu jeu){
		int x_hero = jeu.getHero().getX();
		int y_hero = jeu.getHero().getY();
		int x_ennemi = jeu.getEnnemi().getX();
		int y_ennemi = jeu.getEnnemi().getY();
		for(int i = 0; i<jeu.getMap().getHauteur(); ++i){
			for(int j = 0; j<jeu.getMap().getLargeur(); ++j){
				if(x_hero==j&&y_hero==i)
					System.out.print("H");
				else if(x_ennemi==j&&y_ennemi==i&&jeu.getEnnemi().getPv()>0)
					System.out.print("E");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	}
}
