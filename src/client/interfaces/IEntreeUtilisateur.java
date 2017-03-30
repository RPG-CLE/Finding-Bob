package client.interfaces;

import client.Evenement;
/**
 *  Interface IEntreeUtilisateur g�rant les entr�es utilisateur
 *  (ce qu'il tape sur le clavier).
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */
public interface IEntreeUtilisateur {
	/**
	 *  Lit l'entr�e taper par l'utilisateur et g�n�re l'�venement appropri�
	 *  
	 * @return Evenement : l'�venement g�n�r�.
	 *
	 */
	public Evenement lireEntree();

}

