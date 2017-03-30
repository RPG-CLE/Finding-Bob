package client.interfaces;

import client.Jeu;
/**
 * Interface IAJ qui s'occupe des actions de base qui constituent
 * les r�gles du jeu.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */
public interface IAJ {
	/**
	 * Effectue une action. 
	 * 
	 * @param j : le jeu dans le quel s'effectue l'action
	 * @return bool : return true si tout ce passe bien, return false sinon
	 *
	 */
	boolean action(Jeu j);
}
