package client;


import client.interfaces.IAJ;
import client.interfaces.IAction;
import client.interfaces.IAfficheur;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import extension.EntreeConsole;
import framework.PartieProvider;

public class ChargeurPartie {

	public static Jeu charger() {
		IPersonnage principal = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
				"src/configuration/configHeros.txt");
//		IPersonnage vilain = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
//				"src/configuration/configVilain.txt");
//		A supprimer configVilain
		IMap map = (IMap) PartieProvider.getInstance().getObjetByConfig(IMap.class,
				"src/configuration/configMap.txt");
		IAction actionDeplacer = (IAction) PartieProvider.getInstance().getObjetByConfig(IAction.class,
				"src/configuration/configActionDeplacer.txt");
		IEntreeUtilisateur entree = (IEntreeUtilisateur) PartieProvider.getInstance().getObjetByConfig(IEntreeUtilisateur.class,
				"src/configuration/configEntreeIhm.txt");
		
		map.setHero(principal);
		
		principal.addAction(actionDeplacer.getClass(), actionDeplacer);
				
		return new Jeu(principal, map, entree);
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
