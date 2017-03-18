package extension.personnageJouable;

import client.Personnage;
import client.interfaces.IPersonnage;

public class Paladin extends Personnage{

	public Paladin(){
		super();
		this.pv=10;
		this.force=5;
		this.nom="DefaultPaladin";
		this.posX=0;
		this.posY=0;
	}
	
}
