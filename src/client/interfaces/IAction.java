package client.interfaces;

import client.Evenement;
/**
 *  Interface IAction gérant les actions du jeu selon ce que fait l'utilisateur.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IAction {
	/**
	 * Fait faire une action au personnage selon un évenement donné.
	 *  
	 *@param personnage : le personnage effectuant l'action
	 *@param evt : l'évenement déclenchant l'action
	 */
	void action(IPersonnage personnage, Evenement evt);


}

