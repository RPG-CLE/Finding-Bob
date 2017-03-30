package client.interfaces;

import client.Evenement;
/**
 *  Interface IPersonnage regroupent les méthode gérant les personnages du jeu
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IPersonnage {

	double getPv();

	void setPv(double pv);

	double getForce();

	void setForce(double force);

	String getNom();

	void setNom(String nom);

	void setPos(int x, int y);

	int getPosX();

	void setPosX(int x);
	
	int getPosY();

	void setPosY(int y);

	void deplacer(String deplacement);
	
	void addAction(Class<? extends IAction> cl, IAction action);
	
	void doAction(Class<? extends IAction> cl, Evenement evt);
	

	String toString();

}