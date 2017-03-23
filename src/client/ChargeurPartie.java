package client;

import java.util.List;
import java.util.Random;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import framework.PartieProvider;

public class ChargeurPartie {
	public static Jeu charger() {
		IPersonnage principal = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
				"src/configuration/configHeros.txt");
		IPersonnage vilain = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
				"src/configuration/configVilain.txt");
		IMap map = (IMap) PartieProvider.getInstance().getObjetByConfig(IMap.class,
				"src/configuration/configMap.txt");
		
		map.setHero(principal);
		map.setVilain(vilain);
				
		return new Jeu(principal, map, vilain);
	}

	/*
	 * public static IAfficheur chargerAfficheur(){ IAfficheur afficheur =
	 * (IAfficheur)
	 * PartieProvider.getInstance().getObjetByConfig(IAfficheur.class,
	 * "src/configuration/configAfficheur.txt"); if (afficheur ==null)
	 * System.out.println("erreur"); return afficheur; }
	 */
	public static IAfficheur chargerAfficheur() {
		IAfficheur afficheur = (IAfficheur) PartieProvider.getInstance().getObjetByConfig(IAfficheur.class,
				"src/configuration/configAfficheurGraphique.txt");
		if (afficheur == null)
			System.out.println("erreur");
		return afficheur;
	}

	public static IAJ chargerActionJeu() {
		IAJ actionJeu = (IAJ) PartieProvider.getInstance().getObjetByConfig(IAJ.class,
				"src/configuration/configAction.txt");
		if (actionJeu == null)
			System.out.println("erreur");
		return actionJeu;
	}


}
