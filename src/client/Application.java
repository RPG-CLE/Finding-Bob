package client;

import client.interfaces.IAJ;
import client.interfaces.IAfficheur;
import framework.MethodAutorun;
/**
 * Classe Application. Classe qui charge et d�marre le jeu. Comme la classe
 * a l'annotation autorun elle sera lancer au d�marrage par le framework.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
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
		System.exit(0);;
	}

}
