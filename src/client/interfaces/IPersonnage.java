package client.interfaces;

import client.Evenement;
/**
 *  Interface IPersonnage regroupant les m�thodes g�rant les personnages du jeu
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */
public interface IPersonnage {
	/**
	 * Accesseur de l'attribut pv des classes h�ritants de IPersonnage.
	 * 
	 * @return double : le nombre de pv du personnage
	 */
	double getPv();
	/**
	 * Setter de l'attribut pv des classes h�ritants de IPersonnage.
	 * 
	 * @param double : le nouveau nombre de pv du personnage
	 */
	void setPv(double pv);
	/**
	 * Accesseur de l'attribut force des classes h�ritants de IPersonnage.
	 * 
	 * @return double : la force du personnage 
	 */
	double getForce();
	/**
	 * Setter de l'attribut force des classes h�ritants de IPersonnage.
	 * 
	 * @param double : la nouvelle force du personnage
	 */
	void setForce(double force);
	/**
	 * Accesseur de l'attribut nom des classes h�ritants de IPersonnage.
	 * 
	 * @return String : le nom du personnage
	 */
	String getNom();
	/**
	 * Setter de l'attribut nom des classes h�ritants de IPersonnage.
	 * 
	 * @param string : le nouveau nom du personnage
	 */
	void setNom(String nom);
	/**
	 * Setter de la position de du personnage
	 * 
	 * @param int : la nouvelle position sur l'axe X du personnage
	 * @param int : la nouvelle position sur l'axe Y du personnage
	 */
	void setPos(int x, int y);
	/**
	 * Accesseur de l'attribut posX des classes h�ritants de IPersonnage.
	 * 
	 * @return int : la position sur l'axe X du personnage
	 */
	int getPosX();
	/**
	 * Setter de l'attribut pv des classes h�ritants de IPersonnage.
	 * 
	 * @param int : la nouvelle position sur l'axe X du personnage
	 */
	void setPosX(int x);
	/**
	 * Accesseur de l'attribut posY des classes h�ritants de IPersonnage.
	 * 
	 * @return int : la position sur l'axe Y du personnage
	 */
	int getPosY();
	/**
	 * Setter de l'attribut pv des classes h�ritants de IPersonnage.
	 * 
	 * @param int : la nouvelle position sur l'axe Y du personnage
	 */
	void setPosY(int y);

	
	/**
	 * D�place le personnage sur la map
	 * 
	 * @param string : la direction dans la quel on ce d�place
	 */
	void deplacer(String deplacement);
	
	/**
	 * Rajoute une action � la liste d'action du personnage.
	 * 
	 * @param cl : la classe de l'IAction ajout�
	 * @param action : l'IAction ajout�
	 */
	void addAction(Class<? extends IAction> cl, IAction action);
	
	
	/**
	 * Effectue une action selon un �v�nement donn�.
	 * 
	 * @param cl : la classe de l'IAction � eff�ctuer
	 * @param evt : l'�venement d�clenchant l'action
	 */
	void doAction(Class<? extends IAction> cl, Evenement evt);
	

	String toString();

}