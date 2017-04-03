package client.interfaces;

import client.Evenement;
/**
 *  Interface IEntreeUtilisateur gérant les entrées utilisateur
 *  (ce qu'il tape sur le clavier).
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IEntreeUtilisateur {
	/**
	 *  Lit l'entrée taper par l'utilisateur et génére l'évenement approprié
	 *  
	 * @return Evenement : l'évenement généré.
	 *
	 */
	public Evenement lireEntree();

}

