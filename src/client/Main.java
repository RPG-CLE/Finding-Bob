package client;

import extension.ActionJeu;
import framework.ChargeurPartie;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = ChargeurPartie.charger();
		ActionJeu aj = new ActionJeu();
		jeu.afficher();
		System.out.println();
		aj.action(jeu);
		aj.action(jeu);
		aj.action(jeu);

	}

}
