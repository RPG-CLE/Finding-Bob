package extension;

import java.util.Scanner;

import client.Evenement;
import client.interfaces.IEntreeUtilisateur;

public class EntreeConsole implements IEntreeUtilisateur {

	Scanner reader = new Scanner(System.in);
	
	@Override
	public Evenement lireEntree() {
		System.out.println("Saisissez un déplacement : z = haut, s = bas, q = gauche, d = droite ");
		String choix = reader.nextLine();
		
		switch(choix){
		case "z" :
			return new Evenement(Evenement.HAUT);
		case "s" :
			return new Evenement(Evenement.BAS);
		case "q" :
			return new Evenement(Evenement.GAUCHE);
		case "d" :   
			return new Evenement(Evenement.DROITE);
		default:
			break;
		}
		
		
		return null;

	}

}
