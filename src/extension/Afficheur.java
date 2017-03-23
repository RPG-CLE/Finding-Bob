package extension;

import client.Jeu;
import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;

public class Afficheur implements IAfficheur{
	
	public Afficheur(){}
	/* (non-Javadoc)
	 * @see extension.IAfficheur#afficher(client.Jeu)
	 */
	@Override
	public void afficher(Jeu jeu){
		int x_hero = jeu.getHero().getPosX();
		int y_hero = jeu.getHero().getPosY();
		for(int i = 0; i<jeu.getMap().getHauteur(); ++i){
			for(int j = 0; j<jeu.getMap().getLargeur(); ++j){
				IPersonnage ennemi = jeu.getMap().getCase(i, j).getPersonnage();
				if(x_hero==j&&y_hero==i)
					System.out.print("H");
				else if(ennemi!=null&&ennemi.getPv()>0)
					System.out.print("E");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	}
}
