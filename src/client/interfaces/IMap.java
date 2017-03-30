package client.interfaces;

import java.util.List;

import client.Case;
/**
 *  Interface IMap g�rant la map du jeu
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
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
	 *  R�cup�re une case de la map selon ses coordonn�es.
	 *  
	 * @param int x : la position de la case selon l'axe X.
	 * @param int y : la position de la case selon l'axe Y.
	 * @return Case : la case � ces coordonn�es.
	 */
	Case getCase(int x, int y);
	/**
	 *  R�cup�re un ennemie de la map selon ses coordonn�es.
	 *  
	 * @param int x : la position de l'ennemi selon l'axe X.
	 * @param int y : la position de l'ennemi selon l'axe Y.
	 * @return IPersonnage : l'ennemie � ces coordonn�es.
	 * @warning Pr�vu pour r�cup�r� les ennemies mais peut aussi 
	 * r�cup�r� tout type de personnage.
	 */
	IPersonnage getEnnemi(int x, int y);
	public List<IPersonnage> getEnnemis();
	public void setEnnemis(List<IPersonnage> ennemis);

	/**
	 *  D�place vers la droite le personnage passer en param�tre.
	 *  
	 * @param perso : le personnage � d�placer.
	 */
	void deplacerDroite(IPersonnage perso);
	/**
	 *  D�place vers la gauche le personnage passer en param�tre.
	 *  
	 * @param perso : le personnage � d�placer.
	 */
	void deplacerGauche(IPersonnage perso);
	/**
	 *  D�place vers le haut le personnage passer en param�tre.
	 *  
	 * @param perso : le personnage � d�placer.
	 */
	void deplacerHaut(IPersonnage perso);
	/**
	 *  D�place vers le bas le personnage passer en param�tre.
	 *  
	 * @param perso : le personnage � d�placer.
	 */
	void deplacerBas(IPersonnage perso);
	/**
	 *  Enl�ve un personnage de la map
	 *  
	 * @param personnage : le personnage � enlever
	 */
	void removePersonnage(IPersonnage personnage);
	/**
	 *  permet de savoir si la carte a modifier ses textures
	 *  
	 * @return vraie si la texture a changé, faux si seuls les élements ont bougé
	 */
	boolean rechargementTexture();


	
}
