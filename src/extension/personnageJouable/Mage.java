package extension.personnageJouable;

import client.Personnage;
import client.interfaces.IPersonnage;

public class Mage extends Personnage{

	public Mage(){
		super();
		this.pv=3;
		this.force=10;
		this.nom="DefaultMage";
		this.posX=0;
		this.posY=0;
	}
	
}
