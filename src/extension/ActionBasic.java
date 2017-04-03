package extension;

import client.Jeu;
import client.interfaces.IAJ;

public class ActionBasic implements IAJ {
	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
	   j.getHeros().deplacer("droite");
	   j.getHeros().setPos(j.getHeros().getPosX()+1, j.getHeros().getPosY());
	   if(j.getHeros().getPosX()>j.getMap().getLargeur())
		   return false;
	   j.afficher();
	   System.out.println();
	   return true;
	}
}
