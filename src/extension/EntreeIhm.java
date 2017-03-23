package extension;

import client.Evenement;
import client.interfaces.IEntreeUtilisateur;

public class EntreeIhm implements IEntreeUtilisateur {

	char typed;
	
	public char getTyped() {
		return typed;
	}

	public void setTyped(char typed) {
		this.typed = typed;
	}

	@Override
	public Evenement lireEntree() {
		switch(typed){
		case 'z' :
			typed = ' ';
			return new Evenement(Evenement.HAUT);
		case 's' :
			typed = ' ';
			return new Evenement(Evenement.BAS);
		case 'q' :
			typed = ' ';
			return new Evenement(Evenement.GAUCHE);
		case 'd' :   
			typed = ' ';
			return new Evenement(Evenement.DROITE);
		default:
			break;
		}
		
		return null;
	}

}
