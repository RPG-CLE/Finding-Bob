package extension;

import client.Evenement;
import client.interfaces.IAction;
import client.interfaces.IPersonnage;

public class ActionDeplacer implements IAction {

	@Override
	public void action(IPersonnage personnage, Evenement evt) {
		switch(evt.getEvenement()){
		   case Evenement.HAUT :
			   //if(personnage.getPosY()>0)
			   personnage.deplacer("haut");
			   break;
		   case Evenement.BAS :
			   //if(personnage.getPosY()<j.getMap().getHauteur()-1)
			   personnage.deplacer("bas");
			   break;
		   case Evenement.GAUCHE :
			   //if(j.getHero().getPosX()>0)
			   personnage.deplacer("gauche");
			   break;
		   case Evenement.DROITE :
			   //if(j.getHero().getPosX()<j.getMap().getLargeur()-1)
			   personnage.deplacer("droite");
			   break;
		   default:
			   break;
		   }

	}

}
