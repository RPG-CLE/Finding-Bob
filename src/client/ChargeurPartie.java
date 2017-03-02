package client;

import java.io.FileReader;
import java.util.Properties;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;
import extension.ActionJeu;
import framework.PartieProvider;

public class ChargeurPartie {
	public static Jeu charger(){
		IPersonnage principal = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,"src/configuration/configHeros.txt");
		IPersonnage vilain = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,"src/configuration/configVilain.txt");
		Map map = new Map(5,5);
		return new Jeu(principal, map, vilain);
	}
	
	public static IAfficheur chargerAfficheur(){
		IAfficheur afficheur = (IAfficheur) PartieProvider.getInstance().getObjetByConfig(IAfficheur.class,"src/configuration/configAfficheur.txt");
		if (afficheur ==null) System.out.println("erreur");
		return afficheur;
	}
	
	public static IAJ chargerActionJeu(){
		IAJ actionJeu = (IAJ) PartieProvider.getInstance().getObjetByConfig(IAJ.class,"src/configuration/configAction.txt");
		if (actionJeu ==null) System.out.println("erreur");
		return actionJeu;
	}
}
