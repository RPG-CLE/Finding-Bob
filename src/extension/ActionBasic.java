package extension;

import client.IAJ;
import client.Jeu;

public class ActionBasic implements IAJ {
	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
	   j.deplacer("droite");
	   j.getHero().setPos(j.getHero().getX()+1, j.getHero().getY());
	   if(j.getHero().getX()>j.getMap().getLargeur())
		   return false;
	   j.afficher();
	   System.out.println();
	   return true;
	}
}
