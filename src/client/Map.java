package client;

public class Map {
	private Case[][] carte;
	
	public Case[][] getCarte() {
		return carte;
	}

	public void setCarte(Case[][] carte) {
		this.carte = carte;
	}

	public Map(int largeur, int hauteur){
		this.carte = new Case[largeur][hauteur];
	}
	
	public Case getCase(int x, int y){
		return carte[x][y];
	}
}
