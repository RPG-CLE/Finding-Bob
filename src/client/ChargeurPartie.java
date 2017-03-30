package client;


import client.interfaces.IAJ;
import client.interfaces.IAction;
import client.interfaces.IAfficheur;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import extension.EntreeConsole;
import framework.PartieProvider;
/**
 * Classe ChargeurPartie. S'occupe de charger les diff�rents plugin n�cessaires
 * en utilisant les m�thodes du PartieProvider (fraework).
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */
public class ChargeurPartie {

	/**
	 * Chargeur qui s'occupe de charger le jeu. Charge les pulgins de base pour : le personnage principal,
	 *  la map, l'actionDeplacer, et l'IEntreeUtilisateur (ce que tape l'utilisateur sur le clavier)
	 * 
	 * @return Jeu : le jeu avec les plugins de bases.
	 * @warning Si vous voulez de nouveaux plugins de base c'est dans cette m�thode qu'il faut mettre les paths vers
	 * les fichiers de config de ces derniers.
	 */
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
	/**
	 * Chargeur qui s'occupe de charger un afficheur qui s'occupe de la partie graphique du jeu.
	 * Charge le plugins d�finit "de base" comme afficheur. Signal si l'afficheur n'est pas charg�.
	 * 
	 * @return IAfficheur : l'afficheur de base.
	 * @warning Si vous voulez un nouvelle afficheur "de base" changer le path vers votre nouveau 
	 * fichier de config dans cette m�thode.
	 */
	public static IAfficheur chargerAfficheur() {
		IAfficheur afficheur = (IAfficheur) PartieProvider.getInstance().getObjetByConfig(IAfficheur.class,
				"src/configuration/configAfficheurGraphique.txt");
		if (afficheur == null)
			System.out.println("erreur");
		return afficheur;
	}

	/**
	 * Chargeur qui s'occupe de charger un IAJ (interface action jeu) qui s'occupe des actions du jeu.
	 * Charge le plugins d�finit "de base" comme IAJ. Signal si l'IAJ n'est pas charg�.
	 * 
	 * @return IAJ: IAJ de base.
	 * @warning Si vous voulez un nouvelle IAJ "de base" changer le path vers votre nouveau 
	 * fichier de config dans cette m�thode.
	 */
	public static IAJ chargerActionJeu() {
		IAJ actionJeu = (IAJ) PartieProvider.getInstance().getObjetByConfig(IAJ.class,
				"src/configuration/configAction.txt");
		if (actionJeu == null)
			System.out.println("erreur");
		return actionJeu;
	}


}
