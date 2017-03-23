package client;

public class Evenement {
	public static final String HAUT = "haut";
	public static final String BAS = "bas";
	public static final String DROITE = "droite";
	public static final String GAUCHE = "gauche";
	
	String evenement; 

	public Evenement(String evenement) {
		this.evenement = evenement;
	}
	
	public String getEvenement() {
		return evenement;
	}

	public void setEvenement(String evenement) {
		this.evenement = evenement;
	}

}
