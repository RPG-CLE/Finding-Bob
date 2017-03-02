package client;

import java.util.Scanner;
import framework.GameLoader;

public class Main {

	public static void main(String[] args) {
		Game game = GameLoader.load();
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Saissisez le fichier de config (par défaut:'src/configuration/configBasic.txt' ou 'src/configuration/config.txt')");
		String config = reader.nextLine();
		
		IAJ aj = GameLoader.chargerAction(config);
		
		game.show();
		System.out.println();
		
		aj.action(game);
		
		System.out.println("Game over");
	}

}
