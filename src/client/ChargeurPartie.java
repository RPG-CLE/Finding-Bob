package client;

import java.io.FileReader;
import java.util.Properties;

import extension.ActionJeu;
import framework.PartieProvider;

public class ChargeurPartie {
	public static Jeu charger(){
		IPersonnage principal = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,"src/configuration/configHeros.txt");
		IPersonnage vilain = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,"src/configuration/configVilain.txt");
		Map map = new Map(5,5);
		return new Jeu(principal, map, vilain);
	}
}
