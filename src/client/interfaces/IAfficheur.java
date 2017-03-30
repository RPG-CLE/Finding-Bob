package client.interfaces;

import client.Jeu;
/**
 * Interface IAfficheur qui s'occupe de l'affichage graphique de l'application.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall√©e
 *
 */
public interface IAfficheur {

	/**
	 * Affiche l'Ètat actuel du jeu
	 *  
	 * @param jeu : le jeu ‡ afficher
	 *
	 */
	void afficher(Jeu jeu);

}