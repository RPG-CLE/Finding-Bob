package client.interfaces;

import java.util.List;

import client.Case;
/**
 *  Interface IMap gérant la map du jeu
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IMap {
	int getLargeur();
	void setLargeur(int valeur);
	int getHauteur();
	void setHauteur(int valeur);
	int getPositionPersonageX();
	int getPositionPersonageY();
	void setPositionPersonageX(int valeur);
	void setPositionPersonageY(int valeur);
	void setHero(IPersonnage heros);
	void setVilain(IPersonnage vilain);
	/**
	 *  Récupère une case de la map selon ses coordonnées.
	 *  
	 * @param int x : la position de la case selon l'axe X.
	 * @param int y : la position de la case selon l'axe Y.
	 * @return Case : la case à ces coordonnées.
	 */
	Case getCase(int x, int y);
	/**
	 *  Récupère un ennemie de la map selon ses coordonnées.
	 *  
	 * @param int x : la position de l'ennemi selon l'axe X.
	 * @param int y : la position de l'ennemi selon l'axe Y.
	 * @return IPersonnage : l'ennemie à ces coordonnées.
	 * @warning Prévu pour récupéré les ennemies mais peut aussi 
	 * récupéré tout type de personnage.
	 */
	IPersonnage getEnnemi(int x, int y);
	public List<IPersonnage> getEnnemis();
	public void setEnnemis(List<IPersonnage> ennemis);

	/**
	 *  Déplace vers la droite le personnage passer en paramètre.
	 *  
	 * @param perso : le personnage à déplacer.
	 */
	void deplacerDroite(IPersonnage perso);
	/**
	 *  Déplace vers la gauche le personnage passer en paramètre.
	 *  
	 * @param perso : le personnage à déplacer.
	 */
	void deplacerGauche(IPersonnage perso);
	/**
	 *  Déplace vers le haut le personnage passer en paramètre.
	 *  
	 * @param perso : le personnage à déplacer.
	 */
	void deplacerHaut(IPersonnage perso);
	/**
	 *  Déplace vers le bas le personnage passer en paramètre.
	 *  
	 * @param perso : le personnage à déplacer.
	 */
	void deplacerBas(IPersonnage perso);
	/**
	 *  Enlève un personnage de la map
	 *  
	 * @param personnage : le personnage à enlever
	 */
	void removePersonnage(IPersonnage personnage);


	
}
