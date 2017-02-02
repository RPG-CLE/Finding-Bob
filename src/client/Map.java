package client;

public class Map {
	private Case[][] carte;
	private int largeur;
	private int hauteur;
	
	public Map(int largeur, int hauteur){
		this.carte = new Case[largeur][hauteur];
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	
	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}
	
	public Case getCase(int x, int y){
		return carte[x][y];
	}
}
