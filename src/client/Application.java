package client;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import framework.MethodAutorun;

@MethodAutorun(run="lancer")
public class Application{

	public void lancer(){
		Jeu jeu = ChargeurPartie.charger();
		IAfficheur afficheur = ChargeurPartie.chargerAfficheur();
		jeu.setAfficheur(afficheur);
		IAJ aj = ChargeurPartie.chargerActionJeu();
		jeu.afficher();
		System.out.println("");
		while(aj.action(jeu));
		System.out.println("Game over");
	}

}
