package client.interfaces;

import client.Jeu;
/**
 * Interface IAfficheur qui s'occupe de l'affichage graphique de l'application.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IAfficheur {

	/**
	 * Affiche l'état actuel du jeu
	 *  
	 * @param jeu : le jeu à afficher
	 *
	 */
	void afficher(Jeu jeu);

}