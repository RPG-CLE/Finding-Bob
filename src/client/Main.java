package client;

import java.util.Scanner;
import framework.ChargeurPartie;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = ChargeurPartie.charger();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Saissisez le fichier de config (par défaut:'src/configuration/configBasic.txt' ou 'src/configuration/config.txt')");
		String config = reader.nextLine();
		IAJ aj = ChargeurPartie.chargerAction(config);
		jeu.afficher();
		System.out.println();
		while(aj.action(jeu));
		System.out.println("Game over");
	}

}
