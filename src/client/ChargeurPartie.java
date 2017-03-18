package client;

import java.util.List;
import java.util.Random;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import client.interfaces.IPersonnage;
import framework.PartieProvider;

public class ChargeurPartie {
	public static Jeu charger() {
		IPersonnage principal = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
				"src/configuration/configHeros.txt");
		IPersonnage vilain = (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
				"src/configuration/configVilain.txt");
		Map map = new Map(20, 20);

		for (int i = 0; i < map.getLargeur(); i++) {
			for (int j = 0; j < map.getHauteur(); j++) {
				map.setCase(i, j, new Case("Herbe"));
			}
		}
		genererMonde(map, 0.09);
		
		map.getCase(principal.getPosX(), principal.getPosY()).setPersonnage(principal);
		map.getCase(vilain.getPosX(), vilain.getPosY()).setPersonnage(vilain);
		
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

	public static void genererMonde(Map map, double pourcentage) {
		int caseX, caseY;
		Random random = new Random();

		System.out.println(pourcentage * map.getHauteur()*map.getLargeur());
		for (int i = 0; i < pourcentage * map.getHauteur()*map.getLargeur(); i++) {
			caseX = random.nextInt(map.getLargeur());
			caseY = random.nextInt(map.getHauteur());
			
			if(map.getCase(caseX, caseY) == null) continue;
			
			map.getCase(caseX, caseY).setNom("Eau");
			
			List<Case> listCase = map.getCasesAdjacentes(caseX, caseY);
			for(Case _case : listCase){
				if(!_case.getNom().equals("Eau")){
					_case.setNom("Terre");
				}
			}

		}

	}

}
