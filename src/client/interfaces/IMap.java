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
	 *  Récupére une case de la map selon ses coordonnées.
	 *  
	 * @param int x : la position de la case selon l'axe X.
	 * @param int y : la position de la case selon l'axe Y.
	 * @return Case : la case à ces coordonnées.
	 */
	Case getCase(int x, int y);
	/**
	 *  Récupére un ennemie de la map selon ses coordonnées.
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
	/**
	 *  permet de savoir si la carte a modifier ses textures
	 *  
	 * @return vraie si la texture a changé, faux si seuls les élements ont bougé
	 */
	boolean rechargementTexture();


	
}
