package framework;

import client.Jeu;
import client.Map;
import client.Personnage;

public class ChargeurPartie {
	public static Jeu charger(){
		Personnage principal = new Personnage(10, 2, "Robert", 0, 0);
		//Personnage vilain = new Personnage(10, 1, "Vilain", 3, 0);
		Map map = new Map(3,3);
		return new Jeu(principal, map);
	}
}
