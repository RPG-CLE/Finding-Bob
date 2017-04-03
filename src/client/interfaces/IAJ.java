package client.interfaces;

import client.Jeu;
/**
 * Interface IAJ qui s'occupe des actions de base qui constituent
 * les règles du jeu.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IAJ {
	/**
	 * Effectue une action. 
	 * 
	 * @param j : le jeu dans le quel s'effectue l'action
	 * @return bool : return faux si le jeu est terminé (ou qu'aucune action est disponible)
	 *
	 */
	boolean action(Jeu j);
}
