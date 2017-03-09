package extension;

import client.Jeu;
import client.interfaces.IAJ;

public class ActionBasic implements IAJ {
	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
	   j.deplacer("droite");
	   j.getHero().setPos(j.getHero().getPosX()+1, j.getHero().getPosY());
	   if(j.getHero().getPosX()>j.getMap().getLargeur())
		   return false;
	   j.afficher();
	   System.out.println();
	   return true;
	}
}
