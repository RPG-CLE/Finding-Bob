package client;

import java.util.Scanner;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;

public class Main {

	public static void main(String[] args) {
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
