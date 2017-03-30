package client.interfaces;

import client.Evenement;
/**
 *  Interface IAction g�rant les actions du jeu selon ce que fait l'utilisateur.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */
public interface IAction {
	/**
	 * Fait faire une action au personnage selon un �venement donn�.
	 *  
	 *@param personnage : le personnage effectuant l'action
	 *@param evt : l'�venement d�clenchant l'action
	 */
	void action(IPersonnage personnage, Evenement evt);


}

