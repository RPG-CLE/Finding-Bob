package client;

/**
 * Classe Evenement. S'occupe de définir plusieurs événements : les 
 * entr�es que peut faire l'utilisateur avec le clavier.
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 * @warning Ne s'occupe pour l'instant que des déplacements : haut,bas,gauche,droite.
 *
 */

public class Evenement {
	public static final String HAUT = "haut";
	public static final String BAS = "bas";
	public static final String DROITE = "droite";
	public static final String GAUCHE = "gauche";
	
	String evenement; 
	/**
	 * Constructeur de la classe Evenement
	 * 
	 * @param evenement : string qui définit à quel type d'événement on a affaire (haut, bas, etc...).
	 * @return Evenement: événement avec l'attribut evenement définit.
	 */
	public Evenement(String evenement) {
		this.evenement = evenement;
	}
	
	/**
	 * Constructeur de la classe Evenement
	 * 
	 * @param enumValue : valeur qui définit à quel type d'événement on a affaire suivant l'ordre de déclaration (haut, bas, etc...).
	 * @return Evenement: événement avec l'attribut evenement définit.
	 */
	public Evenement(int enumValue) {
		switch (enumValue) {
		case 0:
			this.evenement = HAUT;
			break;
		case 1:
			this.evenement = BAS;
			break;
		case 2:
			this.evenement = GAUCHE;
			break;
		case 3:
			this.evenement = DROITE;
			break;
		}
	}
	
	/**
	 * Accesseur de l'attribut evenement de la classe Evenement
	 * 
	 * @return String: l'attribut evenement de la classe Evenement
	 */
	public String getEvenement() {
		return evenement;
	}
	/**
	 * Setter de l'attribut evenement de la classe Evenement
	 * 
	 * @return evenement : le nouveau evenement
	 */
	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

}
