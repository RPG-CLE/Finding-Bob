package client;

import java.util.Scanner;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;
import framework.IApplication;

public class Application  implements IApplication{

	public void lancer(){
		Jeu jeu = ChargeurPartie.charger();
		IAfficheur afficheur = ChargeurPartie.chargerAfficheur();
		jeu.setAfficheur(afficheur);
		IAJ aj = ChargeurPartie.chargerActionJeu();
		jeu.afficher();
		System.out.println();
		while(aj.action(jeu));
		System.out.println("Game over");
	}

}
